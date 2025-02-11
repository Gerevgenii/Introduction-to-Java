package org.example;

import java.util.List;

public class Paragraph{
    private final List<Markup> list;

    public Paragraph(List<Markup> list) {
        this.list = list;
    }

    public void toMarkdown(StringBuilder stringBuilder) {
        for (Markup Markup : list) {
            Markup.toMarkdown(stringBuilder);
        }
    }
    public void toTex(StringBuilder stringBuilder) {
        for (Markup Markup : list) {
            Markup.toTex(stringBuilder);
        }
    }
}
