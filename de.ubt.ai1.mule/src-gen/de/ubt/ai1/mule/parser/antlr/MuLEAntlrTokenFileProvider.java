/*
 * generated by Xtext 2.19.0
 */
package de.ubt.ai1.mule.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class MuLEAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("de/ubt/ai1/mule/parser/antlr/internal/InternalMuLE.tokens");
	}
}