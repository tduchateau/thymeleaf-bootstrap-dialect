package fr.tduchateau.thymeleaf.bootstrap.dialect;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

import fr.tduchateau.thymeleaf.bootstrap.matcher.ElementNameWithoutPrefixProcessorMatcher;
import fr.tduchateau.thymeleaf.bootstrap.processor.BootstrapTagProcessor;

/**
 * Bootstrap dialect.
 * 
 * @author Thibault Duchateau	
 */
public class BootstrapDialect extends AbstractDialect {

	public static final String DIALECT_PREFIX = null;
	public static final String LAYOUT_NAMESPACE = "http://github.com/tduchateau/thymeleaf/bootstrap";
	
	public String getPrefix() {
		return DIALECT_PREFIX;
	}

	public boolean isLenient() {
		return false;
	}

	@Override
	public Set<IProcessor> getProcessors() {
		final Set<IProcessor> processors = new HashSet<IProcessor>();
		processors.add(new BootstrapTagProcessor(new ElementNameWithoutPrefixProcessorMatcher("bootstrap:nav")));
		return processors;
	}
}