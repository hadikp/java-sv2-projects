package schoolrecords;

public enum MarkType {

    A(5, "excellent"), B(4, "very good"), C(3, "improvement needed"), D(2, "close fail"), F(1, "fail");

    private final int valueMark;
    private final String textMark;

    MarkType(int valueMark, String textMark) {
        this.valueMark = valueMark;
        this.textMark = textMark;
    }

    public int getValueMark() {
        return valueMark;
    }

    public String getTextMark() {
        return textMark;
    }
}
