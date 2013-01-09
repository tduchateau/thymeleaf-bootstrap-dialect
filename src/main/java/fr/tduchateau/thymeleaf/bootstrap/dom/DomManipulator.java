package fr.tduchateau.thymeleaf.bootstrap.dom;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Node;

import fr.tduchateau.thymeleaf.bootstrap.component.Nav;
import fr.tduchateau.thymeleaf.bootstrap.component.Tab;

/**
 * 
 *
 * @author Thibault Duchateau
 */
public class DomManipulator {

	// Logger
	private static Logger logger = LoggerFactory.getLogger(DomManipulator.class);

		
	public static void generateNav(Element element, Nav nav){
		    	
    	for (Node child : element.getChildren()) {
    		
    		if (child != null && child instanceof Element) {
    			
    			Element tabChildTag = (Element) child;
    			String tabChildTagName = tabChildTag.getNormalizedName();
    			
    			tabChildTag.setProcessable(true);
    			
    			if (tabChildTagName != null && tabChildTagName.equals("tab")) {
    				
    				String tabId = tabChildTag.getAttributeValue("id");
    				
    				if(tabId == null){
    					logger.error("The 'id' attribute is required !");
    					throw new IllegalArgumentException("The 'id' attribute is required !");
    				}
    				
    				String tabLabel = tabChildTag.getAttributeValue("label");
    				String tabActive = tabChildTag.getAttributeValue("active");
    				List<Node> tabContent = tabChildTag.getChildren();
    				
    				nav.addTab(new Tab(tabId, tabLabel, tabActive, tabContent));
    			}
    		}
    	}

    	for (Element elementToAdd : nav.toNodes()) {
    		element.getParent().insertBefore(element, elementToAdd);
    	}
	}
	
}