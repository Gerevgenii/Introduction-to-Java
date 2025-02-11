package org.example;

public class Text implements Markdown{

    private final String string;

    public Text(String string) {
        this.string = string;
    }
    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append(string);
    }
}
