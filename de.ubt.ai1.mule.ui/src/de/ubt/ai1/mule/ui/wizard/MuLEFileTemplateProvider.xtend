/*
 * generated by Xtext 2.16.0
 */
package de.ubt.ai1.mule.ui.wizard


import org.eclipse.xtext.ui.wizard.template.FileTemplate
import org.eclipse.xtext.ui.wizard.template.IFileGenerator
import org.eclipse.xtext.ui.wizard.template.IFileTemplateProvider

/**
 * Create a list with all file templates to be shown in the template new file wizard.
 * 
 * Each template is able to generate one or more files.
 */
class MuLEFileTemplateProvider implements IFileTemplateProvider {
	override getFileTemplates() {
//		#[]
		#[new EmptyProgramFile/*, new HelloWorldFile */]
	}
	
	// this is the actually used template
	def static String getEmptyFileTemplate(String name) {
		'''
			program ?name?
			import IO
			
			main
			endmain
		'''
	}
}

// currently not used
@FileTemplate(label="Empty Program", icon="file_template.png", description="Create an empty MuLE program file.")
final class EmptyProgramFile {

	override generateFiles(IFileGenerator generator) {
		generator.generate('''?folder?/?name?.mule''', '''
			program ?name?
			
			import IO 
			
			main 
				
			endmain
		''')
	}
}

//@FileTemplate(label="Hello World", icon="file_template.png", description="Create a hello world program file for MuLE.")
//final class HelloWorldFile {
//	val helloName = combo("Hello Name:", #["Xtext", "World", "Foo", "Bar"], "The name to say 'Hello' to")
//
//	override generateFiles(IFileGenerator generator) {
//		generator.generate('''?folder?/?name?.mule''', '''
//			/*
//			 * This is an example program
//			 */
//			import IO
//			
//			main 
//			 	io.writeString("Hello, ?helloName?!")
//			endmain
//		''')
//	}
//}
