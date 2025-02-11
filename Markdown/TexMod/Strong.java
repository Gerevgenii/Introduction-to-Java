package org.example;

import java.util.List;

public class Strong implements Markup {

    private final List<Markup> list;

    public Strong(List<Markup> list) {
        this.list = list;
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append("\\textbf{");
        for (Markup markup : list) {
            markup.toMarkdown(stringBuilder);
        }
        stringBuilder.append("}");
    }

    @Override
    public void toTex(StringBuilder stringBuilder) {
        stringBuilder.append("\\textbf{");
        for (Markup markup : list) {
            markup.toTex(stringBuilder);
        }
        stringBuilder.append("}");
    }
}
