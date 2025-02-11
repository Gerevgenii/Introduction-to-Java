package org.example;

import java.util.List;

public class Strikeout implements Markup {

    private final List<Markup> list;

    public Strikeout(List<Markup> list) {
        this.list = list;
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append("\\textst{");
        for (Markup Markup : list) {
            Markup.toMarkdown(stringBuilder);
        }
        stringBuilder.append("}");
    }
    @Override
    public void toTex(StringBuilder stringBuilder) {
        stringBuilder.append("\\textst{");
        for (Markup Markup : list) {
            Markup.toTex(stringBuilder);
        }
        stringBuilder.append("}");
    }
}
