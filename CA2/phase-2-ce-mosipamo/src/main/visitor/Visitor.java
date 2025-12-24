package main.visitor;


/*GOALs:
*   1. print out scope changes each time a new scope starts
*   2. print the identifier if it is initialized
*   3. print the identifier if it is used
*   4. print out the name of the function when it is defined
*   5. print out the name of the function when it is used
*
* */

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.statement.CompoundStatement;

public abstract class Visitor<T> implements IVisitor<T> {
    @Override
    public T visit(TypeSpecifier program) { return null ;}

    @Override
    public T visit(TranslationUnit translationUnit) { return null ;}

    @Override
    public T visit(ExternalDeclaration externalDeclaration) { return null ;}

    @Override
    public T visit(FunctionDefinition functionDefinition) { return null ;}

    @Override
    public T visit(Declaration declaration) { return null ;}

    @Override
    public T visit(DeclarationList declarationList) { return null ;}

    @Override
    public T visit(Declarator declarator) { return null ;}

    @Override
    public T visit(CompoundStatement compoundStatement) { return null ;}

    @Override
    public T visit(DeclarationSpecifiers declarationSpecifiers) { return null ;}
}