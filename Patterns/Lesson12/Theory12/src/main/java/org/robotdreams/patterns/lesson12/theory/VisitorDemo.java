package org.robotdreams.patterns.lesson12.theory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class VisitorDemo {
    public void start() {
        System.out.println("Starting Visitor Demo");

        HtmlTextVisitor htmlVisitor = new HtmlTextVisitor();
        HtmlParser parser = new HtmlParser(htmlVisitor);
        parser.parse("<html lang='uk'><head></head><body>" +
                "<div><button click='abc' click='def'>click me</button></div>" +
                "<br/></body></html>");
        HtmlTag parsedResult = htmlVisitor.getResult();

        System.out.println("hierarchy created by visitor:");
        System.out.println(parsedResult.toString());

        new HtmlDuplicatedAttributeVisitor().visitTag(parsedResult);

        System.out.println();
        System.out.println("after removing duplicates by visitor:");
        System.out.println(parsedResult);
    }
}

class HtmlParser {

    private final HtmlTextVisitor htmlVisitor;

    public HtmlParser(HtmlTextVisitor htmlVisitor) {

        this.htmlVisitor = htmlVisitor;
    }

    public void parse(String text) {

        // imitate we are parsing real text
        htmlVisitor.visitOpenTag("html");

        htmlVisitor.visitAttribute("lang");
        htmlVisitor.visitAttributeValue("uk");

        htmlVisitor.visitOpenTag("head");
        htmlVisitor.visitCloseTag("head");

        htmlVisitor.visitOpenTag("body");

        htmlVisitor.visitOpenTag("div");

        htmlVisitor.visitOpenTag("button");
        htmlVisitor.visitAttribute("click");
        htmlVisitor.visitAttributeValue("abc");
        htmlVisitor.visitAttribute("click");
        htmlVisitor.visitAttributeValue("def");
        htmlVisitor.visitTextContent("click me");
        htmlVisitor.visitCloseTag("button");

        htmlVisitor.visitCloseTag("div");

        htmlVisitor.visitTag("br");

        htmlVisitor.visitCloseTag("body");
        htmlVisitor.visitCloseTag("html");
    }
}

class HtmlTextVisitor {

    private String currentAttribute;
    private final CustomArrayList<HtmlTag> tagHierarchy = new CustomArrayList<>();

    private HtmlTag rootElement;

    public void visitOpenTag(String tag) {
        tagHierarchy.add(new HtmlTag(tag));
    }

    public void visitAttribute(String attribute) {
        currentAttribute = attribute;
    }

    public void visitAttributeValue(String attributeValue) {
        tagHierarchy.last().addAttribute(new HtmlAttribute(currentAttribute, attributeValue));
    }

    public void visitCloseTag(String tag) {
        if (tagHierarchy.isEmpty())
            throw new UnsupportedOperationException("No open tag found");

        HtmlTag last = tagHierarchy.last();
        if (!Objects.equals(last.getTag(), tag))
            throw new UnsupportedOperationException("Closing tag should match opening one");

        tagHierarchy.removeLast();

        if (!tagHierarchy.isEmpty())
            tagHierarchy.last().addChild(last);
        else
            rootElement = last;
    }

    public void visitTag(String tag) {
        if (tagHierarchy.isEmpty())
            throw new UnsupportedOperationException("No parent tag found");

        tagHierarchy.last().addChild(new HtmlTag(tag));
    }

    public void visitTextContent(String contents) {
        if (tagHierarchy.isEmpty())
            throw new UnsupportedOperationException("No open tag found");

        tagHierarchy.last().setContents(contents);
    }

    public HtmlTag getResult() {
        return rootElement;
    }
}

class HtmlTreeVisitor {
    public void visitTag(HtmlTag tag) {

    }

    public void visitAttribute(HtmlAttribute attribute) {

    }
}

class HtmlTag {

    private final String tag;
    private final ArrayList<HtmlAttribute> attributes = new ArrayList<>();
    private final ArrayList<HtmlTag> children = new ArrayList<>();
    private String contents;


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<").append(this.tag);

        for (HtmlAttribute attribute : attributes) {
            stringBuilder.append(" ").append(attribute.toString());
        }
        stringBuilder.append(">");
        stringBuilder.append(System.getProperty("line.separator"));

        for (HtmlTag child : children) {
            stringBuilder.append(child.toString());
        }

        if (contents != null)
            stringBuilder.append(contents);

        stringBuilder.append("</").append(this.tag).append(">");
        stringBuilder.append(System.getProperty("line.separator"));

        return stringBuilder.toString();
    }

    public HtmlTag(String tag) {

        this.tag = tag;
    }

    public void addAttribute(HtmlAttribute attribute) {
        this.attributes.add(attribute);
    }

    public void addChild(HtmlTag tag) {
        children.add(tag);
    }

    public String getTag() {
        return tag;
    }

    public ArrayList<HtmlAttribute> getAttributes() {
        return attributes;
    }

    public ArrayList<HtmlTag> getChildren() {
        return children;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}

class HtmlAttribute {
    private final String name;

    private final String value;

    public HtmlAttribute(String name, String value) {

        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "='" + value + "'";
    }
}

class HtmlDuplicatedAttributeVisitor {
    public void visitTag(HtmlTag tag) {
        ArrayList<HtmlAttribute> attributes = tag.getAttributes();
        HashSet<String> uniqueAttributes = new HashSet<>();

        for (int i = 0; i < attributes.size(); i++) {
            HtmlAttribute attribute = attributes.get(i);

            if (uniqueAttributes.contains(attribute.getName())) {
                attributes.remove(attribute);
                i--;
            } else {
                uniqueAttributes.add(attribute.getName());
            }
        }

        for (HtmlTag child : tag.getChildren()) {
            visitTag(child);
        }
    }
}

