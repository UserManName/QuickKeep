package bekerov.psu.quickkeep.item;

public class Note {

    private String headlineText;
    private String anotherText;

    public Note() {
        this.headlineText = "Заголовок";
        this.anotherText = "Содержаниеttе";
    }

    public Note(String headlineText, String anotherText) {
        this.headlineText = headlineText;
        this.anotherText = anotherText;
    }

    public String getHeadlineText() {
        return headlineText;
    }

    public void setHeadlineText(String headlineText) {
        this.headlineText = headlineText;
    }

    public String getAnotherText() {
        return anotherText;
    }

    public void setAnotherText(String anotherText) {
        this.anotherText = anotherText;
    }
}
