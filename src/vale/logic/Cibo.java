package vale.logic;

import javafx.scene.image.Image;

public class Cibo implements Cloneable{
    private Image image;
    public String nome;

    @Override
    public Cibo clone() throws CloneNotSupportedException {
        return (Cibo)super.clone();
    }

    public final static String CILIEGIA = "ciliegia";
    public final static String PERA = "pera";
    public final static String LATTE = "latte";
    public final static String PANCAKE = "pancake";
    public final static String THE = "the";

    public final static String PESCA = "pesca";
    public final static String COLA = "cola";
    public final static String TORTA = "torta";
    public final static String GAMBERIFRITTI = "gamberifritti";
    public final static String SPIEDINO = "spiedino";

    public final static String FORMAGGIO = "formaggio";
    public final static String CIAMBELLA = "ciambella";
    public final static String ANANAS = "ananas";
    public final static String HOTDOG = "hotdog";
    public final static String POLLO = "pollo";

    public final static String CROSTATA = "crostata";
    public final static String CIOCCOLATO = "cioccolato";
    public final static String MELA = "mela";
    public final static String POPCORN = "popcorn";
    public final static String INSALATA = "insalata";

    public final static String KIWI = "kiwi";
    public final static String PANINO = "panino";
    public final static String PANE = "pane";
    public final static String PIZZA = "pizza";
    public final static String SUSHI = "sushi";

    public final static String PASTA = "pasta";
    public final static String UVA = "uva";
    public final static String LECCALECCA = "leccalecca";
    public final static String LIMONE = "limone";
    public final static String BISTECCA = "bistecca";
    public final static String COLAZIONESALATA = "colazione salata";

    public Cibo(String nome)
    {
        this.nome = nome;

        String url="";

        // mi dispiace :-(
        switch (this.nome)
        {
            case Cibo.CILIEGIA:
                url = "000";
                break;

            case Cibo.PERA:
                url = "001";
                break;

            case Cibo.LATTE:
                url = "002";
                break;

            case Cibo.PANCAKE:
                url = "003";
                break;

            case Cibo.THE:
                url = "004";
                break;




            case Cibo.PESCA:
                url = "005";
                break;

            case Cibo.COLA:
                url = "006";
                break;

            case Cibo.TORTA:
                url = "007";
                break;

            case Cibo.GAMBERIFRITTI:
                url = "008";
                break;

            case Cibo.SPIEDINO:
                url = "009";
                break;


            case Cibo.FORMAGGIO:
                url = "010";
                break;

            case Cibo.CIAMBELLA:
                url = "011";
                break;

            case Cibo.ANANAS:
                url = "012";
                break;

            case Cibo.HOTDOG:
                url = "013";
                break;

            case Cibo.POLLO:
                url = "014";
                break;




            case Cibo.CROSTATA:
                url = "015";
                break;

            case Cibo.CIOCCOLATO:
                url = "016";
                break;

            case Cibo.MELA:
                url = "017";
                break;

            case Cibo.POPCORN:
                url = "018";
                break;

            case Cibo.INSALATA:
                url = "019";
                break;




            case Cibo.KIWI:
                url = "020";
                break;

            case Cibo.PANINO:
                url = "021";
                break;

            case Cibo.PANE:
                url = "022";
                break;

            case Cibo.PIZZA:
                url = "023";
                break;

            case Cibo.SUSHI:
                url = "024";
                break;




            case Cibo.PASTA:
                url = "025";
                break;

            case Cibo.UVA:
                url = "026";
                break;

            case Cibo.LECCALECCA:
                url = "027";
                break;

            case Cibo.LIMONE:
                url = "028";
                break;

            case Cibo.BISTECCA:
                url = "029";
                break;

            case Cibo.COLAZIONESALATA:
                url = "030";
                break;


        }

        this.image = new Image("file:/home/vale/intellijProjects/FarmVerdure2/out/production/FarmVerdure2/vale/view/fxml/img/tile"+url+".png");
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Cibo) && nome.equals(((Cibo) obj).nome);
    }

    public Image getImage() {
        return image;
    }
}
