package org.example;

import java.util.List;

public class Emphasis implements Markup {

    private final List<Markup> list;

    public Emphasis(List<Markup> list) {
        this.list = list;
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append("\\emph{");
        for (Markup Markup : list) {
            Markup.toMarkdown(stringBuilder);
        }
        stringBuilder.append('}');
    }

    @Override
    public void toTex(StringBuilder stringBuilder) {
        stringBuilder.append("\\emph{");
        for (Markup Markup : list) {
            Markup.toTex(stringBuilder);
        }
        stringBuilder.append('}');
    }
}
