package fr.tduchateau.thymeleaf.bootstrap.component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Node;
import org.thymeleaf.dom.Text;

/**
 * Generci Nav component.
 *
 * @author Thibault Duchateau
 */
public class Nav {

	protected String type;
	protected List<Tab> tabs;
	protected List<String> cssClasses;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Tab> getTabs() {
		return tabs;
	}

	public void setTabs(List<Tab> tabs) {
		this.tabs = tabs;
	}

	public void addTab(Tab tab) {
		if (this.tabs == null) {
			this.tabs = new ArrayList<Tab>();
		}
		this.tabs.add(tab);
	}

	public List<String> getCssClasses() {
		return cssClasses;
	}

	public void setCssClasses(List<String> cssClasses) {
		this.cssClasses = cssClasses;
	}

	public void addCssClass(String cssClass) {
		if (this.cssClasses == null) {
			this.cssClasses = new LinkedList<String>();
		}
		this.cssClasses.add(cssClass);
	}
	
	public List<Element> toNodes() {
		List<Element> retval = new ArrayList<Element>();

		Element ul = new Element("ul");
		ul.setProcessable(true);
		ul.setAttribute("class", join(cssClasses, " "));
		
		for (Tab tab : this.tabs) {
			Element li = new Element("li");

			if (tab.getActive() != null && !tab.getActive().equals("")) {
				li.setAttribute("class", "active");
			}

			Element link = new Element("a");
			link.setAttribute("href", "#" + tab.getId());
			link.setAttribute("data-toggle", "tab");
			link.addChild(new Text(tab.getLabel()));

			li.addChild(link);

			ul.addChild(li);
		}

		retval.add(ul);

		Element divContent = new Element("div");
		divContent.setAttribute("class", "tab-content");

		for (Tab tab : this.tabs) {
			Element divTabContent = new Element("div");
			divTabContent.setAttribute("id", tab.getId());

			if (tab.getActive() != null && !tab.getActive().equals("")) {
				divTabContent.setAttribute("class", "tab-pane active");
			} else {
				divTabContent.setAttribute("class", "tab-pane");
			}
            
            List<Node> children = tab.getContent();
			for(Node node : children){
				node.setProcessable(true);
				node.setRecomputeProcessorsImmediately(true);
			}
			divTabContent.setChildren(children);
			
			divContent.addChild(divTabContent);
		}

		retval.add(divContent);

		return retval;
	}
	
	public static String join( List<String> list , String replacement  ) {
        StringBuilder b = new StringBuilder();
        for( String item: list ) { 
            b.append( replacement ).append( item );
        }
        return b.toString().substring( replacement.length() );
    }
}