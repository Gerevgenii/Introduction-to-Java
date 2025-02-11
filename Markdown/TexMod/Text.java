package org.example;

public class Text implements Markup {

    private final String string;

    public Text(String string) {
        this.string = string;
    }
    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append(string);
    }

    @Override
    public void toTex(StringBuilder stringBuilder) {
        stringBuilder.append(string);
    }
}
