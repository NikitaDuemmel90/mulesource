/*
 * generated by Xtext 2.19.0
 */
package de.ubt.ai1.mule.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import de.ubt.ai1.mule.ide.contentassist.antlr.internal.InternalMuLEParser;
import de.ubt.ai1.mule.services.MuLEGrammarAccess;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class MuLEParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(MuLEGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, MuLEGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getCompilationUnitAccess().getAlternatives_0(), "rule__CompilationUnit__Alternatives_0");
			builder.put(grammarAccess.getProgramElementAccess().getAlternatives(), "rule__ProgramElement__Alternatives");
			builder.put(grammarAccess.getNamedElementAccess().getAlternatives(), "rule__NamedElement__Alternatives");
			builder.put(grammarAccess.getDataTypeAccess().getAlternatives(), "rule__DataType__Alternatives");
			builder.put(grammarAccess.getBasicTypeAccess().getTypeNameAlternatives_0(), "rule__BasicType__TypeNameAlternatives_0");
			builder.put(grammarAccess.getVisibilityModifierAccess().getAlternatives(), "rule__VisibilityModifier__Alternatives");
			builder.put(grammarAccess.getTypeDeclarationAccess().getAlternatives(), "rule__TypeDeclaration__Alternatives");
			builder.put(grammarAccess.getFeatureAccess().getAlternatives(), "rule__Feature__Alternatives");
			builder.put(grammarAccess.getStatementAccess().getAlternatives(), "rule__Statement__Alternatives");
			builder.put(grammarAccess.getAssignmentOrOperationCallAccess().getAlternatives_0(), "rule__AssignmentOrOperationCall__Alternatives_0");
			builder.put(grammarAccess.getEqualityExpressionAccess().getOpAlternatives_1_1_0(), "rule__EqualityExpression__OpAlternatives_1_1_0");
			builder.put(grammarAccess.getComparisonExpressionAccess().getOpAlternatives_1_1_0(), "rule__ComparisonExpression__OpAlternatives_1_1_0");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getOpAlternatives_1_1_0(), "rule__AdditiveExpression__OpAlternatives_1_1_0");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getOpAlternatives_1_1_0(), "rule__MultiplicativeExpression__OpAlternatives_1_1_0");
			builder.put(grammarAccess.getAtomicExpressionAccess().getAlternatives(), "rule__AtomicExpression__Alternatives");
			builder.put(grammarAccess.getAtomicExpressionAccess().getValueAlternatives_5_1_0(), "rule__AtomicExpression__ValueAlternatives_5_1_0");
			builder.put(grammarAccess.getAtomicExpressionAccess().getOpAlternatives_7_1_0(), "rule__AtomicExpression__OpAlternatives_7_1_0");
			builder.put(grammarAccess.getSymbolRefAccessModifierAccess().getAlternatives(), "rule__SymbolRefAccessModifier__Alternatives");
			builder.put(grammarAccess.getListInitAccess().getRightAlternatives_2_1_0(), "rule__ListInit__RightAlternatives_2_1_0");
			builder.put(grammarAccess.getListInitFunctionAccess().getOpAlternatives_1_0(), "rule__ListInitFunction__OpAlternatives_1_0");
			builder.put(grammarAccess.getCompilationUnitAccess().getGroup(), "rule__CompilationUnit__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
			builder.put(grammarAccess.getMainProcedureAccess().getGroup(), "rule__MainProcedure__Group__0");
			builder.put(grammarAccess.getDeclaredTypeAccess().getGroup(), "rule__DeclaredType__Group__0");
			builder.put(grammarAccess.getDeclaredTypeAccess().getGroup_1(), "rule__DeclaredType__Group_1__0");
			builder.put(grammarAccess.getDeclaredTypeAccess().getGroup_1_2(), "rule__DeclaredType__Group_1_2__0");
			builder.put(grammarAccess.getReferenceTypeAccess().getGroup(), "rule__ReferenceType__Group__0");
			builder.put(grammarAccess.getListTypeAccess().getGroup(), "rule__ListType__Group__0");
			builder.put(grammarAccess.getOperationTypeAccess().getGroup(), "rule__OperationType__Group__0");
			builder.put(grammarAccess.getOperationTypeAccess().getGroup_3(), "rule__OperationType__Group_3__0");
			builder.put(grammarAccess.getOperationTypeAccess().getGroup_3_1(), "rule__OperationType__Group_3_1__0");
			builder.put(grammarAccess.getOperationTypeAccess().getGroup_5(), "rule__OperationType__Group_5__0");
			builder.put(grammarAccess.getEnumerationAccess().getGroup(), "rule__Enumeration__Group__0");
			builder.put(grammarAccess.getEnumerationAccess().getGroup_6(), "rule__Enumeration__Group_6__0");
			builder.put(grammarAccess.getCompositionAccess().getGroup(), "rule__Composition__Group__0");
			builder.put(grammarAccess.getCompositionAccess().getGroup_4(), "rule__Composition__Group_4__0");
			builder.put(grammarAccess.getCompositionAccess().getGroup_4_2(), "rule__Composition__Group_4_2__0");
			builder.put(grammarAccess.getCompositionAccess().getGroup_7(), "rule__Composition__Group_7__0");
			builder.put(grammarAccess.getCompositionAccess().getGroup_7_2(), "rule__Composition__Group_7_2__0");
			builder.put(grammarAccess.getCompositionAccess().getGroup_7_2_2(), "rule__Composition__Group_7_2_2__0");
			builder.put(grammarAccess.getTypeParameterAccess().getGroup(), "rule__TypeParameter__Group__0");
			builder.put(grammarAccess.getTypeParameterAccess().getGroup_1(), "rule__TypeParameter__Group_1__0");
			builder.put(grammarAccess.getAttributeAccess().getGroup(), "rule__Attribute__Group__0");
			builder.put(grammarAccess.getParameterAccess().getGroup(), "rule__Parameter__Group__0");
			builder.put(grammarAccess.getOperationAccess().getGroup(), "rule__Operation__Group__0");
			builder.put(grammarAccess.getOperationAccess().getGroup_6(), "rule__Operation__Group_6__0");
			builder.put(grammarAccess.getOperationAccess().getGroup_6_1(), "rule__Operation__Group_6_1__0");
			builder.put(grammarAccess.getOperationAccess().getGroup_8(), "rule__Operation__Group_8__0");
			builder.put(grammarAccess.getOperationAccess().getGroup_9(), "rule__Operation__Group_9__0");
			builder.put(grammarAccess.getBlockAccess().getGroup(), "rule__Block__Group__0");
			builder.put(grammarAccess.getReturnStatementAccess().getGroup(), "rule__ReturnStatement__Group__0");
			builder.put(grammarAccess.getExitStatementAccess().getGroup(), "rule__ExitStatement__Group__0");
			builder.put(grammarAccess.getVariableDeclarationAccess().getGroup(), "rule__VariableDeclaration__Group__0");
			builder.put(grammarAccess.getAssignmentOrOperationCallAccess().getGroup(), "rule__AssignmentOrOperationCall__Group__0");
			builder.put(grammarAccess.getAssignmentOrOperationCallAccess().getGroup_1(), "rule__AssignmentOrOperationCall__Group_1__0");
			builder.put(grammarAccess.getLoopStatementAccess().getGroup(), "rule__LoopStatement__Group__0");
			builder.put(grammarAccess.getIfStatementAccess().getGroup(), "rule__IfStatement__Group__0");
			builder.put(grammarAccess.getIfStatementAccess().getGroup_5(), "rule__IfStatement__Group_5__0");
			builder.put(grammarAccess.getElseIfAccess().getGroup(), "rule__ElseIf__Group__0");
			builder.put(grammarAccess.getLetStatementAccess().getGroup(), "rule__LetStatement__Group__0");
			builder.put(grammarAccess.getLetStatementAccess().getGroup_7(), "rule__LetStatement__Group_7__0");
			builder.put(grammarAccess.getElseLetAccess().getGroup(), "rule__ElseLet__Group__0");
			builder.put(grammarAccess.getOrExpressionAccess().getGroup(), "rule__OrExpression__Group__0");
			builder.put(grammarAccess.getOrExpressionAccess().getGroup_1(), "rule__OrExpression__Group_1__0");
			builder.put(grammarAccess.getAndExpressionAccess().getGroup(), "rule__AndExpression__Group__0");
			builder.put(grammarAccess.getAndExpressionAccess().getGroup_1(), "rule__AndExpression__Group_1__0");
			builder.put(grammarAccess.getEqualityExpressionAccess().getGroup(), "rule__EqualityExpression__Group__0");
			builder.put(grammarAccess.getEqualityExpressionAccess().getGroup_1(), "rule__EqualityExpression__Group_1__0");
			builder.put(grammarAccess.getComparisonExpressionAccess().getGroup(), "rule__ComparisonExpression__Group__0");
			builder.put(grammarAccess.getComparisonExpressionAccess().getGroup_1(), "rule__ComparisonExpression__Group_1__0");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getGroup(), "rule__AdditiveExpression__Group__0");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getGroup_1(), "rule__AdditiveExpression__Group_1__0");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getGroup(), "rule__MultiplicativeExpression__Group__0");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_1(), "rule__MultiplicativeExpression__Group_1__0");
			builder.put(grammarAccess.getExponentExpressionAccess().getGroup(), "rule__ExponentExpression__Group__0");
			builder.put(grammarAccess.getExponentExpressionAccess().getGroup_1(), "rule__ExponentExpression__Group_1__0");
			builder.put(grammarAccess.getAtomicExpressionAccess().getGroup_2(), "rule__AtomicExpression__Group_2__0");
			builder.put(grammarAccess.getAtomicExpressionAccess().getGroup_3(), "rule__AtomicExpression__Group_3__0");
			builder.put(grammarAccess.getAtomicExpressionAccess().getGroup_4(), "rule__AtomicExpression__Group_4__0");
			builder.put(grammarAccess.getAtomicExpressionAccess().getGroup_5(), "rule__AtomicExpression__Group_5__0");
			builder.put(grammarAccess.getAtomicExpressionAccess().getGroup_6(), "rule__AtomicExpression__Group_6__0");
			builder.put(grammarAccess.getAtomicExpressionAccess().getGroup_7(), "rule__AtomicExpression__Group_7__0");
			builder.put(grammarAccess.getAtomicExpressionAccess().getGroup_8(), "rule__AtomicExpression__Group_8__0");
			builder.put(grammarAccess.getAtomicExpressionAccess().getGroup_9(), "rule__AtomicExpression__Group_9__0");
			builder.put(grammarAccess.getLambdaExpressionAccess().getGroup(), "rule__LambdaExpression__Group__0");
			builder.put(grammarAccess.getLambdaExpressionAccess().getGroup_3(), "rule__LambdaExpression__Group_3__0");
			builder.put(grammarAccess.getLambdaExpressionAccess().getGroup_3_1(), "rule__LambdaExpression__Group_3_1__0");
			builder.put(grammarAccess.getLambdaExpressionAccess().getGroup_5(), "rule__LambdaExpression__Group_5__0");
			builder.put(grammarAccess.getSuperExpressionAccess().getGroup(), "rule__SuperExpression__Group__0");
			builder.put(grammarAccess.getSymbolReferenceAccess().getGroup(), "rule__SymbolReference__Group__0");
			builder.put(grammarAccess.getSymbolReferenceAccess().getGroup_3(), "rule__SymbolReference__Group_3__0");
			builder.put(grammarAccess.getSymbolRefAccessModifierAccess().getGroup_0(), "rule__SymbolRefAccessModifier__Group_0__0");
			builder.put(grammarAccess.getSymbolRefAccessModifierAccess().getGroup_0_2(), "rule__SymbolRefAccessModifier__Group_0_2__0");
			builder.put(grammarAccess.getSymbolRefAccessModifierAccess().getGroup_0_2_1(), "rule__SymbolRefAccessModifier__Group_0_2_1__0");
			builder.put(grammarAccess.getSymbolRefAccessModifierAccess().getGroup_1(), "rule__SymbolRefAccessModifier__Group_1__0");
			builder.put(grammarAccess.getSymbolRefAccessModifierAccess().getGroup_2(), "rule__SymbolRefAccessModifier__Group_2__0");
			builder.put(grammarAccess.getSymbolRefCompositionInitAccess().getGroup(), "rule__SymbolRefCompositionInit__Group__0");
			builder.put(grammarAccess.getSymbolRefCompositionInitAccess().getGroup_2(), "rule__SymbolRefCompositionInit__Group_2__0");
			builder.put(grammarAccess.getSymbolRefCompositionInitAccess().getGroup_2_1(), "rule__SymbolRefCompositionInit__Group_2_1__0");
			builder.put(grammarAccess.getSymbolRefCompositionAttributeAccess().getGroup(), "rule__SymbolRefCompositionAttribute__Group__0");
			builder.put(grammarAccess.getListInitAccess().getGroup(), "rule__ListInit__Group__0");
			builder.put(grammarAccess.getListInitAccess().getGroup_2(), "rule__ListInit__Group_2__0");
			builder.put(grammarAccess.getListInitFunctionAccess().getGroup(), "rule__ListInitFunction__Group__0");
			builder.put(grammarAccess.getListInitElementsAccess().getGroup(), "rule__ListInitElements__Group__0");
			builder.put(grammarAccess.getListInitElementsAccess().getGroup_1(), "rule__ListInitElements__Group_1__0");
			builder.put(grammarAccess.getCompilationUnitAccess().getIsProgramAssignment_0_0(), "rule__CompilationUnit__IsProgramAssignment_0_0");
			builder.put(grammarAccess.getCompilationUnitAccess().getIsLibraryAssignment_0_1(), "rule__CompilationUnit__IsLibraryAssignment_0_1");
			builder.put(grammarAccess.getCompilationUnitAccess().getNameAssignment_1(), "rule__CompilationUnit__NameAssignment_1");
			builder.put(grammarAccess.getCompilationUnitAccess().getImportsAssignment_2(), "rule__CompilationUnit__ImportsAssignment_2");
			builder.put(grammarAccess.getCompilationUnitAccess().getProgramElementsAssignment_3(), "rule__CompilationUnit__ProgramElementsAssignment_3");
			builder.put(grammarAccess.getCompilationUnitAccess().getMainAssignment_4(), "rule__CompilationUnit__MainAssignment_4");
			builder.put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1(), "rule__Import__ImportedNamespaceAssignment_1");
			builder.put(grammarAccess.getMainProcedureAccess().getBlockAssignment_2(), "rule__MainProcedure__BlockAssignment_2");
			builder.put(grammarAccess.getDeclaredTypeAccess().getTypeAssignment_0(), "rule__DeclaredType__TypeAssignment_0");
			builder.put(grammarAccess.getDeclaredTypeAccess().getTypeParamsAssignment_1_1(), "rule__DeclaredType__TypeParamsAssignment_1_1");
			builder.put(grammarAccess.getDeclaredTypeAccess().getTypeParamsAssignment_1_2_1(), "rule__DeclaredType__TypeParamsAssignment_1_2_1");
			builder.put(grammarAccess.getBasicTypeAccess().getTypeNameAssignment(), "rule__BasicType__TypeNameAssignment");
			builder.put(grammarAccess.getReferenceTypeAccess().getTypeAssignment_2(), "rule__ReferenceType__TypeAssignment_2");
			builder.put(grammarAccess.getListTypeAccess().getTypeAssignment_2(), "rule__ListType__TypeAssignment_2");
			builder.put(grammarAccess.getOperationTypeAccess().getParamTypesAssignment_3_0(), "rule__OperationType__ParamTypesAssignment_3_0");
			builder.put(grammarAccess.getOperationTypeAccess().getParamTypesAssignment_3_1_1(), "rule__OperationType__ParamTypesAssignment_3_1_1");
			builder.put(grammarAccess.getOperationTypeAccess().getTypeAssignment_5_1(), "rule__OperationType__TypeAssignment_5_1");
			builder.put(grammarAccess.getEnumerationAccess().getVisibilityAssignment_0(), "rule__Enumeration__VisibilityAssignment_0");
			builder.put(grammarAccess.getEnumerationAccess().getNameAssignment_2(), "rule__Enumeration__NameAssignment_2");
			builder.put(grammarAccess.getEnumerationAccess().getValuesAssignment_5(), "rule__Enumeration__ValuesAssignment_5");
			builder.put(grammarAccess.getEnumerationAccess().getValuesAssignment_6_1(), "rule__Enumeration__ValuesAssignment_6_1");
			builder.put(grammarAccess.getEnumerationValueAccess().getNameAssignment(), "rule__EnumerationValue__NameAssignment");
			builder.put(grammarAccess.getCompositionAccess().getVisibilityAssignment_0(), "rule__Composition__VisibilityAssignment_0");
			builder.put(grammarAccess.getCompositionAccess().getAbstractAssignment_1(), "rule__Composition__AbstractAssignment_1");
			builder.put(grammarAccess.getCompositionAccess().getNameAssignment_3(), "rule__Composition__NameAssignment_3");
			builder.put(grammarAccess.getCompositionAccess().getTypeParamsAssignment_4_1(), "rule__Composition__TypeParamsAssignment_4_1");
			builder.put(grammarAccess.getCompositionAccess().getTypeParamsAssignment_4_2_1(), "rule__Composition__TypeParamsAssignment_4_2_1");
			builder.put(grammarAccess.getCompositionAccess().getSuperTypeAssignment_7_1(), "rule__Composition__SuperTypeAssignment_7_1");
			builder.put(grammarAccess.getCompositionAccess().getSuperTypeParamsAssignment_7_2_1(), "rule__Composition__SuperTypeParamsAssignment_7_2_1");
			builder.put(grammarAccess.getCompositionAccess().getSuperTypeParamsAssignment_7_2_2_1(), "rule__Composition__SuperTypeParamsAssignment_7_2_2_1");
			builder.put(grammarAccess.getCompositionAccess().getTypeDeclarationsAssignment_8(), "rule__Composition__TypeDeclarationsAssignment_8");
			builder.put(grammarAccess.getCompositionAccess().getAttributesAssignment_9(), "rule__Composition__AttributesAssignment_9");
			builder.put(grammarAccess.getCompositionAccess().getOperationsAssignment_10(), "rule__Composition__OperationsAssignment_10");
			builder.put(grammarAccess.getTypeParameterAccess().getNameAssignment_0(), "rule__TypeParameter__NameAssignment_0");
			builder.put(grammarAccess.getTypeParameterAccess().getSuperTypeAssignment_1_1(), "rule__TypeParameter__SuperTypeAssignment_1_1");
			builder.put(grammarAccess.getAttributeAccess().getVisibilityAssignment_0(), "rule__Attribute__VisibilityAssignment_0");
			builder.put(grammarAccess.getAttributeAccess().getNameAssignment_2(), "rule__Attribute__NameAssignment_2");
			builder.put(grammarAccess.getAttributeAccess().getTypeAssignment_4(), "rule__Attribute__TypeAssignment_4");
			builder.put(grammarAccess.getParameterAccess().getNameAssignment_1(), "rule__Parameter__NameAssignment_1");
			builder.put(grammarAccess.getParameterAccess().getTypeAssignment_3(), "rule__Parameter__TypeAssignment_3");
			builder.put(grammarAccess.getOperationAccess().getOverrideAssignment_0(), "rule__Operation__OverrideAssignment_0");
			builder.put(grammarAccess.getOperationAccess().getVisibilityAssignment_1(), "rule__Operation__VisibilityAssignment_1");
			builder.put(grammarAccess.getOperationAccess().getAbstractAssignment_2(), "rule__Operation__AbstractAssignment_2");
			builder.put(grammarAccess.getOperationAccess().getNameAssignment_4(), "rule__Operation__NameAssignment_4");
			builder.put(grammarAccess.getOperationAccess().getParamsAssignment_6_0(), "rule__Operation__ParamsAssignment_6_0");
			builder.put(grammarAccess.getOperationAccess().getParamsAssignment_6_1_1(), "rule__Operation__ParamsAssignment_6_1_1");
			builder.put(grammarAccess.getOperationAccess().getTypeAssignment_8_1(), "rule__Operation__TypeAssignment_8_1");
			builder.put(grammarAccess.getOperationAccess().getBlockAssignment_9_0(), "rule__Operation__BlockAssignment_9_0");
			builder.put(grammarAccess.getBlockAccess().getStatementsAssignment_1(), "rule__Block__StatementsAssignment_1");
			builder.put(grammarAccess.getReturnStatementAccess().getExpressionAssignment_2(), "rule__ReturnStatement__ExpressionAssignment_2");
			builder.put(grammarAccess.getVariableDeclarationAccess().getNameAssignment_1(), "rule__VariableDeclaration__NameAssignment_1");
			builder.put(grammarAccess.getVariableDeclarationAccess().getTypeAssignment_3(), "rule__VariableDeclaration__TypeAssignment_3");
			builder.put(grammarAccess.getAssignmentOrOperationCallAccess().getRightAssignment_1_2(), "rule__AssignmentOrOperationCall__RightAssignment_1_2");
			builder.put(grammarAccess.getLoopStatementAccess().getBlockAssignment_2(), "rule__LoopStatement__BlockAssignment_2");
			builder.put(grammarAccess.getIfStatementAccess().getExpressionAssignment_1(), "rule__IfStatement__ExpressionAssignment_1");
			builder.put(grammarAccess.getIfStatementAccess().getBlockAssignment_3(), "rule__IfStatement__BlockAssignment_3");
			builder.put(grammarAccess.getIfStatementAccess().getElseIfsAssignment_4(), "rule__IfStatement__ElseIfsAssignment_4");
			builder.put(grammarAccess.getIfStatementAccess().getElseBlockAssignment_5_1(), "rule__IfStatement__ElseBlockAssignment_5_1");
			builder.put(grammarAccess.getElseIfAccess().getExpressionAssignment_1(), "rule__ElseIf__ExpressionAssignment_1");
			builder.put(grammarAccess.getElseIfAccess().getBlockAssignment_3(), "rule__ElseIf__BlockAssignment_3");
			builder.put(grammarAccess.getLetStatementAccess().getVariableAssignment_1(), "rule__LetStatement__VariableAssignment_1");
			builder.put(grammarAccess.getLetStatementAccess().getExpressionAssignment_3(), "rule__LetStatement__ExpressionAssignment_3");
			builder.put(grammarAccess.getLetStatementAccess().getBlockAssignment_5(), "rule__LetStatement__BlockAssignment_5");
			builder.put(grammarAccess.getLetStatementAccess().getElseLetsAssignment_6(), "rule__LetStatement__ElseLetsAssignment_6");
			builder.put(grammarAccess.getLetStatementAccess().getElseBlockAssignment_7_1(), "rule__LetStatement__ElseBlockAssignment_7_1");
			builder.put(grammarAccess.getElseLetAccess().getVariableAssignment_1(), "rule__ElseLet__VariableAssignment_1");
			builder.put(grammarAccess.getElseLetAccess().getExpressionAssignment_3(), "rule__ElseLet__ExpressionAssignment_3");
			builder.put(grammarAccess.getElseLetAccess().getBlockAssignment_5(), "rule__ElseLet__BlockAssignment_5");
			builder.put(grammarAccess.getOrExpressionAccess().getOpAssignment_1_1(), "rule__OrExpression__OpAssignment_1_1");
			builder.put(grammarAccess.getOrExpressionAccess().getRightAssignment_1_2(), "rule__OrExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getAndExpressionAccess().getOpAssignment_1_1(), "rule__AndExpression__OpAssignment_1_1");
			builder.put(grammarAccess.getAndExpressionAccess().getRightAssignment_1_2(), "rule__AndExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getEqualityExpressionAccess().getOpAssignment_1_1(), "rule__EqualityExpression__OpAssignment_1_1");
			builder.put(grammarAccess.getEqualityExpressionAccess().getRightAssignment_1_2(), "rule__EqualityExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getComparisonExpressionAccess().getOpAssignment_1_1(), "rule__ComparisonExpression__OpAssignment_1_1");
			builder.put(grammarAccess.getComparisonExpressionAccess().getRightAssignment_1_2(), "rule__ComparisonExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getOpAssignment_1_1(), "rule__AdditiveExpression__OpAssignment_1_1");
			builder.put(grammarAccess.getAdditiveExpressionAccess().getRightAssignment_1_2(), "rule__AdditiveExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getOpAssignment_1_1(), "rule__MultiplicativeExpression__OpAssignment_1_1");
			builder.put(grammarAccess.getMultiplicativeExpressionAccess().getRightAssignment_1_2(), "rule__MultiplicativeExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getExponentExpressionAccess().getOpAssignment_1_1(), "rule__ExponentExpression__OpAssignment_1_1");
			builder.put(grammarAccess.getExponentExpressionAccess().getRightAssignment_1_2(), "rule__ExponentExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getAtomicExpressionAccess().getValueAssignment_2_1(), "rule__AtomicExpression__ValueAssignment_2_1");
			builder.put(grammarAccess.getAtomicExpressionAccess().getValueAssignment_3_1(), "rule__AtomicExpression__ValueAssignment_3_1");
			builder.put(grammarAccess.getAtomicExpressionAccess().getValueAssignment_4_1(), "rule__AtomicExpression__ValueAssignment_4_1");
			builder.put(grammarAccess.getAtomicExpressionAccess().getValueAssignment_5_1(), "rule__AtomicExpression__ValueAssignment_5_1");
			builder.put(grammarAccess.getAtomicExpressionAccess().getOpAssignment_7_1(), "rule__AtomicExpression__OpAssignment_7_1");
			builder.put(grammarAccess.getAtomicExpressionAccess().getExpressionAssignment_7_2(), "rule__AtomicExpression__ExpressionAssignment_7_2");
			builder.put(grammarAccess.getAtomicExpressionAccess().getExpressionAssignment_8_2(), "rule__AtomicExpression__ExpressionAssignment_8_2");
			builder.put(grammarAccess.getAtomicExpressionAccess().getExpressionAssignment_9_2(), "rule__AtomicExpression__ExpressionAssignment_9_2");
			builder.put(grammarAccess.getLambdaExpressionAccess().getParametersAssignment_3_0(), "rule__LambdaExpression__ParametersAssignment_3_0");
			builder.put(grammarAccess.getLambdaExpressionAccess().getParametersAssignment_3_1_1(), "rule__LambdaExpression__ParametersAssignment_3_1_1");
			builder.put(grammarAccess.getLambdaExpressionAccess().getTypeAssignment_5_1(), "rule__LambdaExpression__TypeAssignment_5_1");
			builder.put(grammarAccess.getLambdaExpressionAccess().getBlockAssignment_6(), "rule__LambdaExpression__BlockAssignment_6");
			builder.put(grammarAccess.getSuperExpressionAccess().getMemberCallAssignment_3(), "rule__SuperExpression__MemberCallAssignment_3");
			builder.put(grammarAccess.getSymbolReferenceAccess().getSymbolAssignment_0(), "rule__SymbolReference__SymbolAssignment_0");
			builder.put(grammarAccess.getSymbolReferenceAccess().getCompositionInitAssignment_1(), "rule__SymbolReference__CompositionInitAssignment_1");
			builder.put(grammarAccess.getSymbolReferenceAccess().getAccessModifierAssignment_2(), "rule__SymbolReference__AccessModifierAssignment_2");
			builder.put(grammarAccess.getSymbolReferenceAccess().getMemberCallAssignment_3_1(), "rule__SymbolReference__MemberCallAssignment_3_1");
			builder.put(grammarAccess.getSymbolRefAccessModifierAccess().getParamsAssignment_0_2_0(), "rule__SymbolRefAccessModifier__ParamsAssignment_0_2_0");
			builder.put(grammarAccess.getSymbolRefAccessModifierAccess().getParamsAssignment_0_2_1_1(), "rule__SymbolRefAccessModifier__ParamsAssignment_0_2_1_1");
			builder.put(grammarAccess.getSymbolRefAccessModifierAccess().getAccessModifierAssignment_0_4(), "rule__SymbolRefAccessModifier__AccessModifierAssignment_0_4");
			builder.put(grammarAccess.getSymbolRefAccessModifierAccess().getIndexAssignment_1_2(), "rule__SymbolRefAccessModifier__IndexAssignment_1_2");
			builder.put(grammarAccess.getSymbolRefAccessModifierAccess().getAccessModifierAssignment_1_4(), "rule__SymbolRefAccessModifier__AccessModifierAssignment_1_4");
			builder.put(grammarAccess.getSymbolRefAccessModifierAccess().getAccessModifierAssignment_2_2(), "rule__SymbolRefAccessModifier__AccessModifierAssignment_2_2");
			builder.put(grammarAccess.getSymbolRefCompositionInitAccess().getAttributesAssignment_2_0(), "rule__SymbolRefCompositionInit__AttributesAssignment_2_0");
			builder.put(grammarAccess.getSymbolRefCompositionInitAccess().getAttributesAssignment_2_1_1(), "rule__SymbolRefCompositionInit__AttributesAssignment_2_1_1");
			builder.put(grammarAccess.getSymbolRefCompositionAttributeAccess().getAttributeAssignment_0(), "rule__SymbolRefCompositionAttribute__AttributeAssignment_0");
			builder.put(grammarAccess.getSymbolRefCompositionAttributeAccess().getExpressionAssignment_2(), "rule__SymbolRefCompositionAttribute__ExpressionAssignment_2");
			builder.put(grammarAccess.getListInitAccess().getLeftAssignment_2_0(), "rule__ListInit__LeftAssignment_2_0");
			builder.put(grammarAccess.getListInitAccess().getRightAssignment_2_1(), "rule__ListInit__RightAssignment_2_1");
			builder.put(grammarAccess.getListInitFunctionAccess().getOpAssignment_1(), "rule__ListInitFunction__OpAssignment_1");
			builder.put(grammarAccess.getListInitFunctionAccess().getExpressionAssignment_2(), "rule__ListInitFunction__ExpressionAssignment_2");
			builder.put(grammarAccess.getListInitElementsAccess().getElementsAssignment_1_1(), "rule__ListInitElements__ElementsAssignment_1_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private MuLEGrammarAccess grammarAccess;

	@Override
	protected InternalMuLEParser createParser() {
		InternalMuLEParser result = new InternalMuLEParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public MuLEGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(MuLEGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
