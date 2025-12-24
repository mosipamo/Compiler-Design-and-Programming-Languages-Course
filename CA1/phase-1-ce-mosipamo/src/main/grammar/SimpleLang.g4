grammar SimpleLang;

@header{
    import main.ast.nodes.*;
    import main.ast.nodes.statement.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.expression.operator.*;
    import main.ast.nodes.expression.*;
}

program returns [Program programRet]
    : { $programRet = new Program(); }
    ( t = translationUnit { $programRet.setTranslationUnit($t.translationUnitRet); $programRet.setLine($ctx.getStart().getLine()); } )?
    EOF ;

translationUnit returns [TranslationUnit translationUnitRet]
    : { $translationUnitRet = new TranslationUnit(); }
    ( e = externalDeclaration {$translationUnitRet.addExternalDeclaration($e.externalDeclarationRet); $translationUnitRet.setLine($ctx.getStart().getLine()); } )+; // {$translationUnitRet.getExternalDeclaration();};

externalDeclaration returns [ExternalDeclaration externalDeclarationRet]
    : { $externalDeclarationRet = new ExternalDeclaration(); }
    f = functionDefinition { $externalDeclarationRet.setFunctionDefinition($f.functionDefinitionRet); $externalDeclarationRet.setLine($ctx.getStart().getLine()); }
    | d = declaration { $externalDeclarationRet.setDeclaration($d.declarationRet); $externalDeclarationRet.setLine($ctx.getStart().getLine()); }
    | Semi
    ;

functionDefinition returns [FunctionDefinition functionDefinitionRet]
    : { $functionDefinitionRet = new FunctionDefinition(); }
    (ds=declarationSpecifiers  { $functionDefinitionRet.addDeclarationSpecifiers($ds.declarationSpecifiersRet); $functionDefinitionRet.setLine($ctx.getStart().getLine()); } )?
    d=declarator { $functionDefinitionRet.setDeclarator($d.declaratorRet); $functionDefinitionRet.setLine($ctx.getStart().getLine()); }
    (dl=declarationList { $functionDefinitionRet.addDeclarationList($dl.declarationListRet); $functionDefinitionRet.setLine($ctx.getStart().getLine()); })?
    cs=compoundStatement { $functionDefinitionRet.setCompoundStatement($cs.compoundStatementRet); $functionDefinitionRet.setLine($ctx.getStart().getLine()); } ;

declarationList returns [DeclarationList declarationListRet]
    : { $declarationListRet = new DeclarationList(); }
    ( d = declaration {$declarationListRet.addDeclaration($d.declarationRet); $declarationListRet.setLine($ctx.getStart().getLine()); } )+ ;

expression returns [Expression expressionRet]
    :
    Identifier { IdentifierExpression identifierexpr = new IdentifierExpression($Identifier.text); identifierexpr.setLine($Identifier.getLine()); $expressionRet = identifierexpr; } |
    Constant { ConstantExpression commaexpr = new ConstantExpression($Constant.text); commaexpr.setLine($Constant.getLine()); $expressionRet = commaexpr; }|
    {StringLiteralExpression stringlit = new StringLiteralExpression();} (StringLiteral { stringlit.addStringLiteralExpression($StringLiteral.text); stringlit.setLine($StringLiteral.getLine()); $expressionRet = stringlit; })+
    | LeftParen (e = expression { $expressionRet = $e.expressionRet; }) RightParen
    | LeftParen typ1 = typeName { $expressionRet.setTypeName($typ1.typeNameRet); $expressionRet.setLine($ctx.getStart().getLine()); } RightParen LeftBrace i = initializerList { $expressionRet.setInitializerList($i.initializerListRet); $expressionRet.setLine($ctx.getStart().getLine()); } Comma? RightBrace
    | e1 = expression  LeftBracket e5 = expression  RightBracket  {BinaryExpression bexpr = new BinaryExpression();
                                                                 bexpr.setLeft($e1.expressionRet);
                                                                 bexpr.setRight($e5.expressionRet);
                                                                 bexpr.setOperator("");
                                                                 bexpr.setLine($ctx.getStart().getLine());
                                                                 $expressionRet = bexpr;}                              // Array indexing
    | e2 = expression { $expressionRet = $e2.expressionRet; } LeftParen (a = argumentExpressionList { $expressionRet.setArgumentExpressionList($a.argumentExpressionListRet); $expressionRet.setLine($ctx.getStart().getLine()); })? RightParen                       // Function call
    | e3 = expression { $expressionRet = $e3.expressionRet; } pp=PlusPlus {$expressionRet.addTemp_op($pp.text);}                                                         // Postfix increment
    | e4 = expression { $expressionRet = $e4.expressionRet; } mm=MinusMinus {$expressionRet.addTemp_op($mm.text);}                                                        // Postfix decrement
    | (an=(PlusPlus  |
     MinusMinus |
     Sizeof) )*
    (                                         // Prefix operators (zero or more)
         Identifier { IdentifierExpression identifierexpr = new IdentifierExpression($Identifier.text); identifierexpr.setLine($Identifier.getLine());  $expressionRet = identifierexpr; {$expressionRet.addTemp_op($an.text);} }
       | Constant { ConstantExpression commaexpr = new ConstantExpression($Constant.text); commaexpr.setLine($Constant.getLine()); $expressionRet = commaexpr;}
       | {StringLiteralExpression stringlit = new StringLiteralExpression();} (StringLiteral { stringlit.addStringLiteralExpression($StringLiteral.text); stringlit.setLine($StringLiteral.getLine()); $expressionRet = stringlit; })+
       | LeftParen e6 = expression { $expressionRet = $e6.expressionRet; } RightParen
       | LeftParen typ = typeName { $expressionRet.setTypeName($typ.typeNameRet); $expressionRet.setLine($ctx.getStart().getLine()); } RightParen LeftBrace i1 = initializerList { $expressionRet.setInitializerList($i1.initializerListRet); $expressionRet.setLine($ctx.getStart().getLine()); } Comma? RightBrace
       | uu = unaryOperator (c = castExpression { $expressionRet = $c.castExpressionRet; $expressionRet.setUnaryOperator($uu.unaryOperatorRet); $expressionRet.setLine($ctx.getStart().getLine()); })
       | Sizeof LeftParen typ2 = typeName { $expressionRet.setTypeName($typ2.typeNameRet); $expressionRet.setLine($ctx.getStart().getLine()); } RightParen
    )
    | LeftParen typ3 = typeName { $expressionRet.setTypeName($typ3.typeNameRet); $expressionRet.setLine($ctx.getStart().getLine()); } RightParen ca = castExpression { $expressionRet = $ca.castExpressionRet; }                                  // Cast expression
    | e7 = expression  s = (Star | Div | Mod) e8 = expression {BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft($e7.expressionRet); bexpr.setRight($e8.expressionRet); bexpr.setOperator($s.text); bexpr.setLine($ctx.getStart().getLine()); $expressionRet = bexpr;}                                // Multiplicative
    | e9 = expression s = (Plus | Minus) e10 = expression {BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft($e9.expressionRet); bexpr.setRight($e10.expressionRet); bexpr.setOperator($s.text); bexpr.setLine($ctx.getStart().getLine()); $expressionRet = bexpr;}                                        // Additive
    | e11 = expression s = (LeftShift | RightShift) e12 = expression {BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft($e11.expressionRet); bexpr.setRight($e12.expressionRet); bexpr.setOperator($s.text); bexpr.setLine($ctx.getStart().getLine()); $expressionRet = bexpr;}                                // Shift
    | e13 = expression s = (Less | Greater | LessEqual | GreaterEqual) e14 = expression {BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft($e13.expressionRet); bexpr.setRight($e14.expressionRet); bexpr.setOperator($s.text); bexpr.setLine($ctx.getStart().getLine()); $expressionRet = bexpr;}             // Relational
    | e15 = expression s = (Equal | NotEqual) e16 = expression {BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft($e15.expressionRet); bexpr.setRight($e16.expressionRet); bexpr.setOperator($s.text); bexpr.setLine($ctx.getStart().getLine()); $expressionRet = bexpr;}                                      // Equality
    | e17 = expression s = And e18 = expression {BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft($e17.expressionRet); bexpr.setRight($e18.expressionRet); bexpr.setOperator($s.text); bexpr.setLine($ctx.getStart().getLine()); $expressionRet = bexpr;}                                                 // Bitwise AND
    | e19 = expression s = Xor e20 = expression {BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft($e19.expressionRet); bexpr.setRight($e20.expressionRet); bexpr.setOperator($s.text); bexpr.setLine($ctx.getStart().getLine()); $expressionRet = bexpr;}                                                 // Bitwise XOR
    | e21 = expression s = Or e22 = expression {BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft($e21.expressionRet); bexpr.setRight($e22.expressionRet); bexpr.setOperator($s.text); bexpr.setLine($ctx.getStart().getLine()); $expressionRet = bexpr;}                                                     // Bitwise OR
    | e23 = expression s = AndAnd e24 = expression {BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft($e23.expressionRet); bexpr.setRight($e24.expressionRet); bexpr.setOperator($s.text); bexpr.setLine($ctx.getStart().getLine()); $expressionRet = bexpr;}                                                // Logical AND
    | e25 = expression s = OrOr e26 = expression {BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft($e25.expressionRet); bexpr.setRight($e26.expressionRet); bexpr.setOperator($s.text); bexpr.setLine($ctx.getStart().getLine()); $expressionRet = bexpr;}                                                  // Logical OR
    | e27 = expression sl = Question e28 = expression sr = Colon e29 = expression {ThreeExpression ternaryExpr = new ThreeExpression(); ternaryExpr.setLeft($e27.expressionRet); ternaryExpr.setRight($e29.expressionRet); ternaryExpr.setMid($e28.expressionRet); ternaryExpr.setLeftOp($sl.text); ternaryExpr.setRightOp($sr.text); ternaryExpr.setLine($ctx.getStart().getLine()); $expressionRet = ternaryExpr;}                              // Conditional operator
    | e30 = expression as = assignmentOperator e31 = expression {AssignmentExpression assignExpr = new AssignmentExpression(); assignExpr.setLeft($e30.expressionRet); assignExpr.setRight($e31.expressionRet); assignExpr.setOperator($as.assignmentOperatorRet); assignExpr.setLine($ctx.getStart().getLine()); $expressionRet = assignExpr;}

    | e32 = expression {CommaExpression CommaExpr = new CommaExpression();
                      CommaExpr.addExpression($e32.expressionRet); }
                      (ccc=Comma (e33 = expression)  { CommaExpr.addExpression($e33.expressionRet); CommaExpr.addComma($ccc.text); })+ { CommaExpr.setLine($ctx.getStart().getLine()); $expressionRet = CommaExpr;} ;

argumentExpressionList returns [ArgumentExpressionList argumentExpressionListRet]
    : { $argumentExpressionListRet = new ArgumentExpressionList(); }
    e = expression { $argumentExpressionListRet.addExpression($e.expressionRet); $argumentExpressionListRet.setLine($ctx.getStart().getLine());}
    (Comma (ex = expression { $argumentExpressionListRet.addExpression($ex.expressionRet); $argumentExpressionListRet.setLine($ctx.getStart().getLine()); } ))* ;

unaryOperator returns [UnaryOperator unaryOperatorRet]
    :
    And { $unaryOperatorRet = UnaryOperator.AND; }
    | Star { $unaryOperatorRet = UnaryOperator.STAR; }
    | Plus { $unaryOperatorRet = UnaryOperator.PLUS; }
    | Minus { $unaryOperatorRet = UnaryOperator.MINUS; }
    | Tilde { $unaryOperatorRet = UnaryOperator.TILDE; }
    | Not { $unaryOperatorRet = UnaryOperator.NOT; };

castExpression returns [CastExpression castExpressionRet]
    :
    LeftParen t = typeName { $castExpressionRet = new CastExpression(); $castExpressionRet.setTypeName($t.typeNameRet); $castExpressionRet.setLine($ctx.getStart().getLine()); } RightParen
    c = castExpression { $castExpressionRet = new CastExpression(); $castExpressionRet.setCastExpression($c.castExpressionRet); $castExpressionRet.setLine($ctx.getStart().getLine()); }
    | e=expression { $castExpressionRet = new CastExpression(); $castExpressionRet.setExpression($e.expressionRet); $castExpressionRet.setLine($ctx.getStart().getLine()); } | DigitSequence ;

assignmentOperator returns [AssignmentOperator assignmentOperatorRet]
    :
    Assign             { $assignmentOperatorRet = AssignmentOperator.ASSIGN;}
    | StarAssign         { $assignmentOperatorRet = AssignmentOperator.STAR_ASSIGN;}
    | DivAssign          { $assignmentOperatorRet = AssignmentOperator.DIV_ASSIGN;}
    | ModAssign          { $assignmentOperatorRet = AssignmentOperator.MOD_ASSIGN;}
    | PlusAssign         { $assignmentOperatorRet = AssignmentOperator.PLUS_ASSIGN;}
    | MinusAssign        { $assignmentOperatorRet = AssignmentOperator.MINUS_ASSIGN;}
    | LeftShiftAssign    { $assignmentOperatorRet = AssignmentOperator.LEFT_SHIFT_ASSIGN;}
    | RightShiftAssign   { $assignmentOperatorRet = AssignmentOperator.RIGHT_SHIFT_ASSIGN;}
    | AndAssign          { $assignmentOperatorRet = AssignmentOperator.AND_ASSIGN;}
    | XorAssign          { $assignmentOperatorRet = AssignmentOperator.XOR_ASSIGN;}
    | OrAssign           { $assignmentOperatorRet = AssignmentOperator.OR_ASSIGN;} ;

declaration returns [Declaration declarationRet]
    : { $declarationRet = new Declaration(); }
    ds = declarationSpecifiers { $declarationRet.setDeclarationSpecifiers($ds.declarationSpecifiersRet); $declarationRet.setLine($ctx.getStart().getLine()); }
    (idl = initDeclaratorList { $declarationRet.setInitDeclaratorList($idl.initDeclaratorListRet); $declarationRet.setLine($ctx.getStart().getLine());} ) ? Semi;

declarationSpecifiers returns [DeclarationSpecifiers declarationSpecifiersRet]
    : { $declarationSpecifiersRet = new DeclarationSpecifiers(); }
    (d = declarationSpecifier {$declarationSpecifiersRet.addSpecifier($d.declarationSpecifierRet); $declarationSpecifiersRet.setLine($ctx.getStart().getLine()); })+ ;

declarationSpecifier returns [DeclarationSpecifier declarationSpecifierRet]
    :
    Typedef { $declarationSpecifierRet = new DeclarationSpecifier("typedef"); }
    | (t = typeSpecifier { $declarationSpecifierRet = new DeclarationSpecifier($t.typeSpecifierRet); $declarationSpecifierRet.setLine($ctx.getStart().getLine()); } )
    | Const { $declarationSpecifierRet = new DeclarationSpecifier("const"); $declarationSpecifierRet.setLine($ctx.getStart().getLine()); };

initDeclaratorList returns [InitDeclaratorList initDeclaratorListRet]
    : { $initDeclaratorListRet = new InitDeclaratorList(); }
    a = initDeclarator { $initDeclaratorListRet.addInitDeclarator($a.initDeclaratorRet); $initDeclaratorListRet.setLine($ctx.getStart().getLine());}
    (Comma b = initDeclarator { $initDeclaratorListRet.addInitDeclarator($b.initDeclaratorRet); $initDeclaratorListRet.setLine($ctx.getStart().getLine());})* ;

initDeclarator returns [InitDeclarator initDeclaratorRet]
    : { $initDeclaratorRet = new InitDeclarator();}
    d = declarator { $initDeclaratorRet.setDeclarator($d.declaratorRet); $initDeclaratorRet.setLine($ctx.getStart().getLine());}
    (Assign i = initializer { $initDeclaratorRet.setInitializer($i.initializerRet); $initDeclaratorRet.setLine($ctx.getStart().getLine());} )?;

typeSpecifier returns [TypeSpecifier typeSpecifierRet]
    :
    Void {$typeSpecifierRet = new TypeSpecifier("void"); $typeSpecifierRet.setLine($Void.getLine());}
    | Char {$typeSpecifierRet = new TypeSpecifier("char"); $typeSpecifierRet.setLine($Char.getLine());}
    | Short {$typeSpecifierRet = new TypeSpecifier("short"); $typeSpecifierRet.setLine($Short.getLine());}
    | Int {$typeSpecifierRet = new TypeSpecifier("int"); $typeSpecifierRet.setLine($Int.getLine());}
    | Long {$typeSpecifierRet = new TypeSpecifier("long"); $typeSpecifierRet.setLine($Long.getLine());}
    | Float {$typeSpecifierRet = new TypeSpecifier("float"); $typeSpecifierRet.setLine($Float.getLine());}
    | Double {$typeSpecifierRet = new TypeSpecifier("double"); $typeSpecifierRet.setLine($Double.getLine());}
    | Signed {$typeSpecifierRet = new TypeSpecifier("signed"); $typeSpecifierRet.setLine($Signed.getLine());}
    | Unsigned {$typeSpecifierRet = new TypeSpecifier("unsigned"); $typeSpecifierRet.setLine($Unsigned.getLine());}
    | Bool {$typeSpecifierRet = new TypeSpecifier("bool"); $typeSpecifierRet.setLine($Bool.getLine());}
    | Identifier {$typeSpecifierRet = new TypeSpecifier($Identifier.text); $typeSpecifierRet.setLine($Identifier.getLine());};

specifierQualifierList returns [SpecifierQualifierList specifierQualifierListRet]
    : { $specifierQualifierListRet = new SpecifierQualifierList(); }
    (t=typeSpecifier {$specifierQualifierListRet.setTypeSpecifier($t.typeSpecifierRet); $specifierQualifierListRet.setLine($ctx.getStart().getLine());} | Const)
    (s=specifierQualifierList{ $specifierQualifierListRet.setSpecifierQualifierList($s.specifierQualifierListRet); $specifierQualifierListRet.setLine($ctx.getStart().getLine()); })? ;

declarator returns [Declarator declaratorRet]
    : { $declaratorRet = new Declarator(); }
    (p=pointer {$declaratorRet.setPointer($p.pointerTypeRet); $declaratorRet.setLine($ctx.getStart().getLine());} )?
    d=directDeclarator { $declaratorRet.setDirectDeclarator($d.directDeclaratorRet); $declaratorRet.setLine($ctx.getStart().getLine()); };

directDeclarator returns [DirectDeclarator directDeclaratorRet]
    :
    id=Identifier
      { $directDeclaratorRet = new DirectDeclarator(); $directDeclaratorRet.setIdentifier($id.text); $directDeclaratorRet.setLine($ctx.getStart().getLine()); }
    | LeftParen d=declarator RightParen
      { $directDeclaratorRet = new DirectDeclarator(); $directDeclaratorRet.setDeclarator($d.declaratorRet); $directDeclaratorRet.setLine($ctx.getStart().getLine()); }
    | t=directDeclarator LeftBracket e=expression? RightBracket
      { $directDeclaratorRet = new DirectDeclarator(); $directDeclaratorRet.setDirectDeclarator($t.directDeclaratorRet);
        if ($e.ctx != null)
            $directDeclaratorRet.setExpression($e.expressionRet); $directDeclaratorRet.setLine($ctx.getStart().getLine());
      }
    | t=directDeclarator LeftParen ( p=parameterList | ii=identifierList? ) RightParen
      {
        $directDeclaratorRet = new DirectDeclarator(); $directDeclaratorRet.setDirectDeclarator($t.directDeclaratorRet);
        if ($p.ctx != null)
            $directDeclaratorRet.setParameterList($p.parameterListRet);
        if ($ii.ctx != null)
            $directDeclaratorRet.setIdentifierList($ii.identifierListRet);
        $directDeclaratorRet.setLine($ctx.getStart().getLine());
      }
    ;

pointer returns [PointerType pointerTypeRet]
@init {
    int level = 0;
    boolean hasConst = false;
}
    :
    (Star { level++; } (Const { hasConst = true; })?)+ { $pointerTypeRet = new PointerType(level, hasConst); $pointerTypeRet.setLine($ctx.getStart().getLine());} ;

parameterList returns [ParameterList parameterListRet]
    : {$parameterListRet = new ParameterList(); }
    p=parameterDeclaration {$parameterListRet.addParameterDeclaration($p.parameterDeclarationRet); $parameterListRet.setLine($ctx.getStart().getLine());}
    (Comma pp=parameterDeclaration {$parameterListRet.addParameterDeclaration($p.parameterDeclarationRet); $parameterListRet.setLine($ctx.getStart().getLine());})* ;

parameterDeclaration returns [ParameterDeclaration parameterDeclarationRet]
    :{ $parameterDeclarationRet = new ParameterDeclaration(); }
    (d = declarationSpecifiers { $parameterDeclarationRet.setDeclarationSpecifiers($d.declarationSpecifiersRet); $parameterDeclarationRet.setLine($ctx.getStart().getLine());})
    (de = declarator  { $parameterDeclarationRet.setDeclarator($de.declaratorRet); $parameterDeclarationRet.setLine($ctx.getStart().getLine());}|
    (a = abstractDeclarator { $parameterDeclarationRet.setAbstractDeclarator($a.abstractDeclaratorRet); $parameterDeclarationRet.setLine($ctx.getStart().getLine());} )?) ;

identifierList returns [IdentifierList identifierListRet]
    : { $identifierListRet = new IdentifierList(); }
    id1=Identifier { $identifierListRet.addIdentifier($id1.text); }
    (Comma id2=Identifier { $identifierListRet.addIdentifier($id2.text); })* ;

typeName returns [TypeName typeNameRet]
    : { $typeNameRet = new TypeName(); }
    s=specifierQualifierList {$typeNameRet.setSpecifierQualifierList($s.specifierQualifierListRet); $typeNameRet.setLine($ctx.getStart().getLine());}
    (a=abstractDeclarator {$typeNameRet.setAbstractDeclarator($a.abstractDeclaratorRet); $typeNameRet.setLine($ctx.getStart().getLine());})? ;

abstractDeclarator returns  [AbstractDeclarator abstractDeclaratorRet]
    : { $abstractDeclaratorRet = new AbstractDeclarator(); }
    p=pointer { $abstractDeclaratorRet.addPointerType($p.pointerTypeRet); $abstractDeclaratorRet.setLine($ctx.getStart().getLine());}
    | (pp=pointer {$abstractDeclaratorRet.addPointerType($pp.pointerTypeRet); $abstractDeclaratorRet.setLine($ctx.getStart().getLine());} )?
    d=directAbstractDeclarator {$abstractDeclaratorRet.setDirectAbstractDeclarator($d.directAbstractDeclaratorRet); $abstractDeclaratorRet.setLine($ctx.getStart().getLine());};

directAbstractDeclarator returns [DirectAbstractDeclarator directAbstractDeclaratorRet]
    : LeftBracket e=expression? RightBracket
      {
        $directAbstractDeclaratorRet = new DirectAbstractDeclarator();
        if ($expression.ctx != null) {
            $directAbstractDeclaratorRet.setExpression($e.expressionRet);
        }
        $directAbstractDeclaratorRet.setLine($ctx.getStart().getLine());
      }
    | LeftParen (a=abstractDeclarator | p=parameterList?) RightParen
      {
        $directAbstractDeclaratorRet = new DirectAbstractDeclarator();
        if ($a.ctx != null) {
            $directAbstractDeclaratorRet.setAbstractDeclarator($a.abstractDeclaratorRet);
        } else if ($p.ctx != null) {
            $directAbstractDeclaratorRet.setParameterList($p.parameterListRet);
        }
        $directAbstractDeclaratorRet.setLine($ctx.getStart().getLine());
      }
    | d=directAbstractDeclarator LeftBracket e2=expression? RightBracket
      {
        $directAbstractDeclaratorRet = new DirectAbstractDeclarator(); $directAbstractDeclaratorRet.setDirectAbstractDeclarator($d.directAbstractDeclaratorRet);
        if ($e2.ctx != null)
            $directAbstractDeclaratorRet.setExpression($e2.expressionRet);
        $directAbstractDeclaratorRet.setLine($ctx.getStart().getLine());
      }
    | dd=directAbstractDeclarator LeftParen pp=parameterList? RightParen
      {
        $directAbstractDeclaratorRet = new DirectAbstractDeclarator(); $directAbstractDeclaratorRet.setDirectAbstractDeclarator($dd.directAbstractDeclaratorRet);
        if ($pp.ctx != null)
            $directAbstractDeclaratorRet.setParameterList($pp.parameterListRet);
        $directAbstractDeclaratorRet.setLine($ctx.getStart().getLine());
      }
    ;

initializer returns [Initializer initializerRet]
    : { $initializerRet = new Initializer(); }
    e=expression { $initializerRet.setExpression($e.expressionRet); $initializerRet.setLine($ctx.getStart().getLine());}
    | LeftBrace i=initializerList Comma? RightBrace { $initializerRet.setInitializerList($i.initializerListRet); $initializerRet.setLine($ctx.getStart().getLine());} ;

initializerList returns [InitializerList initializerListRet]
    : { $initializerListRet = new InitializerList();}
    (d=designation)? {$initializerListRet.addDesignation($d.designationRet); $initializerListRet.setLine($ctx.getStart().getLine());}
    i=initializer {$initializerListRet.addInitializer($i.initializerRet); $initializerListRet.setLine($ctx.getStart().getLine());}
    (Comma (dd=designation)? {$initializerListRet.addDesignation($d.designationRet);} ii=initializer {$initializerListRet.addInitializer($i.initializerRet); $initializerListRet.setLine($ctx.getStart().getLine());})* ;

designation returns [Designation designationRet]
    : { $designationRet = new Designation(); }
    (d=designator {$designationRet.addDesignator($d.designatorRet); $designationRet.setLine($ctx.getStart().getLine());})+ Assign ;

designator returns [Designator designatorRet]
    : { $designatorRet = new Designator(); }
    LeftBracket e=expression {$designatorRet.setExpression($e.expressionRet); $designatorRet.setLine($ctx.getStart().getLine());} RightBracket | Dot Identifier ;

statement returns [Statement statementRet]
    :
    c=compoundStatement { $statementRet = $c.compoundStatementRet; $statementRet.setLine($ctx.getStart().getLine());}
    | e=expressionStatement { $statementRet = $e.expressionStatementRet; $statementRet.setLine($ctx.getStart().getLine());}
    | s=selectionStatement { $statementRet = $s.selectionStatementRet; $statementRet.setLine($ctx.getStart().getLine());}
    | i=iterationStatement { $statementRet = $i.iterationStatementRet; $statementRet.setLine($ctx.getStart().getLine());}
    | j=jumpStatement { $statementRet = $j.jumpStatementRet; $statementRet.setLine($ctx.getStart().getLine());} ;

compoundStatement returns [CompoundStatement compoundStatementRet]
    : {$compoundStatementRet = new CompoundStatement();}
    LeftBrace ((b=blockItem {$compoundStatementRet.addBlockItem($b.blockItemRet); $compoundStatementRet.setLine($ctx.getStart().getLine());})+)? RightBrace ;

blockItem returns [BlockItem blockItemRet]
    :
    s=statement {$blockItemRet = new BlockItem(); $blockItemRet.setStatement($s.statementRet); $blockItemRet.setLine($ctx.getStart().getLine()); }
    | d=declaration {$blockItemRet = new BlockItem(); $blockItemRet.setDeclaration($d.declarationRet); $blockItemRet.setLine($ctx.getStart().getLine()); } ;

expressionStatement returns [ExpressionStatement expressionStatementRet]
    : {$expressionStatementRet = new ExpressionStatement();}
    (e=expression {$expressionStatementRet.setExpression($e.expressionRet); $expressionStatementRet.setLine($ctx.getStart().getLine());})? Semi ;

selectionStatement returns [SelectionStatement selectionStatementRet]
    : {$selectionStatementRet = new SelectionStatement();}
    If LeftParen e=expression {$selectionStatementRet.addExpression($e.expressionRet); $selectionStatementRet.setLine($ctx.getStart().getLine());} RightParen s=statement {$selectionStatementRet.addStatement($s.statementRet); $selectionStatementRet.setLine($ctx.getStart().getLine());}
    (Else If LeftParen ee=expression { $selectionStatementRet.addExpression($ee.expressionRet);  $selectionStatementRet.setLine($ctx.getStart().getLine()); } RightParen sss=statement {$selectionStatementRet.addStatement($sss.statementRet); $selectionStatementRet.setLine($ctx.getStart().getLine());}) *
    (Else (ss=statement) {$selectionStatementRet.addStatement($ss.statementRet); $selectionStatementRet.setLine($ctx.getStart().getLine());})? ;

iterationStatement returns [IterationStatement iterationStatementRet]
    :
    While LeftParen e=expression {$iterationStatementRet = new IterationStatement(); $iterationStatementRet.setExpression($e.expressionRet); $iterationStatementRet.setLine($ctx.getStart().getLine()); $iterationStatementRet.setLoopType("while");} RightParen s=statement {$iterationStatementRet.setStatement($s.statementRet); $iterationStatementRet.setLine($ctx.getStart().getLine());}
    | Do ss=statement {$iterationStatementRet = new IterationStatement(); $iterationStatementRet.setStatement($ss.statementRet); $iterationStatementRet.setLine($ctx.getStart().getLine());} While LeftParen ee=expression {$iterationStatementRet.setExpression($ee.expressionRet); $iterationStatementRet.setLine($ctx.getStart().getLine());} RightParen Semi
    | For LeftParen f=forCondition {$iterationStatementRet = new IterationStatement() ;$iterationStatementRet.setForCondition($f.forConditionRet); $iterationStatementRet.setLine($ctx.getStart().getLine()); $iterationStatementRet.setLoopType("for");} RightParen sss=statement {$iterationStatementRet.setStatement($sss.statementRet); $iterationStatementRet.setLine($ctx.getStart().getLine());};

forCondition returns [ForCondition forConditionRet]
    : {$forConditionRet = new ForCondition();}
    (f=forDeclaration {$forConditionRet.setForDeclaration($f.forDeclarationRet); $forConditionRet.setLine($ctx.getStart().getLine());}
    | (e=expression {$forConditionRet.setExpression($e.expressionRet); $forConditionRet.setLine($ctx.getStart().getLine());})?)
    Semi (ff=forExpression {$forConditionRet.addForExpression($ff.forExpressionRet); $forConditionRet.setLine($ctx.getStart().getLine());})? Semi (fff=forExpression{$forConditionRet.addForExpression($fff.forExpressionRet); $forConditionRet.setLine($ctx.getStart().getLine());})? ;

forDeclaration returns [ForDeclaration forDeclarationRet]
    : {$forDeclarationRet = new ForDeclaration();}
    d=declarationSpecifiers {$forDeclarationRet.setDeclarationSpecifiers($d.declarationSpecifiersRet); $forDeclarationRet.setLine($ctx.getStart().getLine());}
    (i=initDeclaratorList {$forDeclarationRet.setInitDeclaratorList($i.initDeclaratorListRet); $forDeclarationRet.setLine($ctx.getStart().getLine());})? ;

forExpression returns [ForExpression forExpressionRet]
    : {$forExpressionRet = new ForExpression();}
    e=expression {$forExpressionRet.addExpression($e.expressionRet); $forExpressionRet.setLine($ctx.getStart().getLine());} (Comma (ee=expression{$forExpressionRet.addExpression($ee.expressionRet); $forExpressionRet.setLine($ctx.getStart().getLine());}))* ;

jumpStatement returns [JumpStatement jumpStatementRet]
    : {$jumpStatementRet = new JumpStatement(); }
    ( Continue | Break | Return (e=expression{$jumpStatementRet.setExpression($e.expressionRet); $jumpStatementRet.setLine($ctx.getStart().getLine());})? ) Semi ;

Break                 : 'break'                 ;
Char                  : 'char'                  ;
Const                 : 'const'                 ;
Continue              : 'continue'              ;
Do                    : 'do'                    ;
Double                : 'double'                ;
Else                  : 'else'                  ;
Float                 : 'float'                 ;
For                   : 'for'                   ;
If                    : 'if'                    ;
Int                   : 'int'                   ;
Long                  : 'long'                  ;
Return                : 'return'                ;
Short                 : 'short'                 ;
Signed                : 'signed'                ;
Sizeof                : 'sizeof'                ;
Switch                : 'switch'                ;
Typedef               : 'typedef'               ;
Unsigned              : 'unsigned'              ;
Void                  : 'void'                  ;
While                 : 'while'                 ;
Bool                  : 'bool'                  ;
LeftParen             : '('                     ;
RightParen            : ')'                     ;
LeftBracket           : '['                     ;
RightBracket          : ']'                     ;
LeftBrace             : '{'                     ;
RightBrace            : '}'                     ;
Less                  : '<'                     ;
LessEqual             : '<='                    ;
Greater               : '>'                     ;
GreaterEqual          : '>='                    ;
LeftShift             : '<<'                    ;
RightShift            : '>>'                    ;
Plus                  : '+'                     ;
PlusPlus              : '++'                    ;
Minus                 : '-'                     ;
MinusMinus            : '--'                    ;
Star                  : '*'                     ;
Div                   : '/'                     ;
Mod                   : '%'                     ;
And                   : '&'                     ;
Or                    : '|'                     ;
AndAnd                : '&&'                    ;
OrOr                  : '||'                    ;
Xor                   : '^'                     ;
Not                   : '!'                     ;
Tilde                 : '~'                     ;
Question              : '?'                     ;
Colon                 : ':'                     ;
Semi                  : ';'                     ;
Comma                 : ','                     ;
Assign                : '='                     ;
StarAssign            : '*='                    ;
DivAssign             : '/='                    ;
ModAssign             : '%='                    ;
PlusAssign            : '+='                    ;
MinusAssign           : '-='                    ;
LeftShiftAssign       : '<<='                   ;
RightShiftAssign      : '>>='                   ;
AndAssign             : '&='                    ;
XorAssign             : '^='                    ;
OrAssign              : '|='                    ;
Equal                 : '=='                    ;
NotEqual              : '!='                    ;
Arrow                 : '->'                    ;
Dot                   : '.'                     ;

Identifier
    : IdentifierNondigit (IdentifierNondigit | Digit)* ;

fragment IdentifierNondigit
    : Nondigit | UniversalCharacterName ;

fragment Nondigit
    : [a-zA-Z_] ;

fragment Digit
    : [0-9] ;

fragment UniversalCharacterName
    : '\\u' HexQuad | '\\U' HexQuad HexQuad ;

fragment HexQuad
    : HexadecimalDigit HexadecimalDigit HexadecimalDigit HexadecimalDigit ;

Constant
    : IntegerConstant | FloatingConstant | CharacterConstant ;

fragment IntegerConstant
    : DecimalConstant IntegerSuffix?
    | OctalConstant IntegerSuffix?
    | HexadecimalConstant IntegerSuffix?
    | BinaryConstant ;

fragment BinaryConstant
    : '0' [bB] [0-1]+ ;

fragment DecimalConstant
    : NonzeroDigit Digit* ;

fragment OctalConstant
    : '0' OctalDigit* ;

fragment HexadecimalConstant
    : HexadecimalPrefix HexadecimalDigit+ ;

fragment HexadecimalPrefix
    : '0' [xX] ;

fragment NonzeroDigit
    : [1-9] ;

fragment OctalDigit
    : [0-7] ;

fragment HexadecimalDigit
    : [0-9a-fA-F] ;

fragment IntegerSuffix
    : UnsignedSuffix LongSuffix? | UnsignedSuffix LongLongSuffix | LongSuffix UnsignedSuffix? | LongLongSuffix UnsignedSuffix? ;

fragment UnsignedSuffix
    : [uU] ;

fragment LongSuffix
    : [lL] ;

fragment LongLongSuffix
    : 'll' | 'LL' ;

fragment FloatingConstant
    : DecimalFloatingConstant | HexadecimalFloatingConstant ;

fragment DecimalFloatingConstant
    : FractionalConstant ExponentPart? FloatingSuffix? | DigitSequence ExponentPart FloatingSuffix? ;

fragment HexadecimalFloatingConstant
    : HexadecimalPrefix (HexadecimalFractionalConstant | HexadecimalDigitSequence) BinaryExponentPart FloatingSuffix? ;

fragment FractionalConstant
    : DigitSequence? Dot DigitSequence | DigitSequence Dot ;

fragment ExponentPart
    : [eE] Sign? DigitSequence ;

fragment Sign
    : [+-] ;

DigitSequence
    : Digit+ ;

fragment HexadecimalFractionalConstant
    : HexadecimalDigitSequence? Dot HexadecimalDigitSequence | HexadecimalDigitSequence Dot ;

fragment BinaryExponentPart
    : [pP] Sign? DigitSequence ;

fragment HexadecimalDigitSequence
    : HexadecimalDigit+ ;

fragment FloatingSuffix
    : [flFL] ;

fragment CharacterConstant
    : '\'' CCharSequence '\'' | 'L\'' CCharSequence '\''| 'u\'' CCharSequence '\'' | 'U\'' CCharSequence '\''
    ;

fragment CCharSequence
    : CChar+ ;

fragment CChar
    : ~['\\\r\n] | EscapeSequence ;

fragment EscapeSequence
    : SimpleEscapeSequence | OctalEscapeSequence | HexadecimalEscapeSequence | UniversalCharacterName ;

fragment SimpleEscapeSequence
    : '\\' ['"?abfnrtv\\] ;

fragment OctalEscapeSequence
    : '\\' OctalDigit OctalDigit? OctalDigit? ;

fragment HexadecimalEscapeSequence
    : '\\x' HexadecimalDigit+ ;

StringLiteral
    : EncodingPrefix? '"' SCharSequence? '"' ;

fragment EncodingPrefix
    : 'u8' | 'u' | 'U' | 'L' ;

fragment SCharSequence
    : SChar+ ;

fragment SChar
    : ~["\\\r\n] | EscapeSequence | '\\\n' | '\\\r\n' ;

MultiLineMacro
    : '#' (~[\n]*? '\\' '\r'? '\n')+ ~ [\n]+ -> channel(HIDDEN) ;

Directive
    : '#' ~[\n]* -> channel(HIDDEN) ;

Whitespace
    : [ \t]+ -> channel(HIDDEN) ;

Newline
    : ('\r' '\n'? | '\n') -> channel(HIDDEN) ;

BlockComment
    : '/*' .*? '*/' -> channel(HIDDEN) ;

LineComment
    : '//' ~[\r\n]* -> channel(HIDDEN) ;