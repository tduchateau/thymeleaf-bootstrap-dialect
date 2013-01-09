package fr.tduchateau.thymeleaf.bootstrap.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.IElementNameProcessorMatcher;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.processor.element.AbstractElementProcessor;

import fr.tduchateau.thymeleaf.bootstrap.component.NavPills;
import fr.tduchateau.thymeleaf.bootstrap.component.NavTabs;
import fr.tduchateau.thymeleaf.bootstrap.constants.NavType;
import fr.tduchateau.thymeleaf.bootstrap.dom.DomManipulator;

/**
 * 
 * 
 * @author Thibault Duchateau
 */
public class BootstrapTagProcessor extends AbstractElementProcessor {

	// Logger
	private static Logger logger = LoggerFactory.getLogger(BootstrapTagProcessor.class);

	public BootstrapTagProcessor(IElementNameProcessorMatcher matcher) {
		super(matcher);
	}

	@Override
	public int getPrecedence() {
		return 0;
	}

	@Override
	protected ProcessorResult processElement(Arguments arguments, Element element) {

		String type = element.getAttributeValue("type");

		NavType navType = null;

		if (type == null) {
			logger.error("The 'type' attribute is required !");
			throw new IllegalArgumentException("The 'type' attribute is required !");
		} else {

			try {
				navType = NavType.valueOf(type.toUpperCase());
			} catch (IllegalArgumentException e) {
				logger.error("{} is not a valid value among {}", type, NavType.values());
				throw new IllegalArgumentException(e);
			}

			switch (navType) {
			case TABS:

				DomManipulator.generateNav(element, new NavTabs());
				break;

			case PILLS:

				DomManipulator.generateNav(element, new NavPills());
				break;

			default:

				DomManipulator.generateNav(element, new NavTabs());
				break;
			}
		}

		// Non leniency
		element.getParent().removeChild(element);

		return ProcessorResult.OK;
	}
}