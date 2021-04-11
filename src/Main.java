public class Main {
    private static final int COST_PER_KM = 100000;
    public static void main(String[] args) {
        String[][] data = {
                {"Eskildstrup", "Maribo", "28"},
                {"Eskildstrup", "Nykoebing F", "13"},
                {"Eskildstrup", "Vordingborg", "24"},
                {"Haslev", "Korsoer", "60"},
                {"Haslev", "Koege", "24"},
                {"Haslev", "Naestved", "25"},
                {"Haslev", "Ringsted", "19"},
                {"Haslev", "Roskilde", "47"},
                {"Haslev", "Slagelse", "48"},
                {"Haslev", "Soroe", "34"},
                {"Haslev", "Vordingborg", "40"},
                {"Holbaek", "Jaergerspris", "34"},
                {"Holbaek", "Kalundborg", "44"},
                {"Holbaek", "Korsoer", "66"},
                {"Holbaek", "Ringsted", "36"},
                {"Holbaek", "Roskilde", "32"},
                {"Holbaek", "Slagelse", "46"},
                {"Holbaek", "Soroe", "34"},
                {"Jaergerspris", "Korsoer", "95"},
                {"Jaergerspris", "Koege", "58"},
                {"Jaergerspris", "Ringsted", "56"},
                {"Jaergerspris", "Roskilde", "33"},
                {"Jaergerspris", "Slagelse", "74"},
                {"Jaergerspris", "Soroe", "63"},
                {"Kalundborg", "Ringsted", "62"},
                {"Kalundborg", "Roskilde", "70"},
                {"Kalundborg", "Slagelse", "39"},
                {"Kalundborg", "Soroe", "51"},
                {"Korsoer", "Naestved", "45"},
                {"Korsoer", "Slagelse", "20"},
                {"Koege", "Naestved", "45"},
                {"Koege", "Ringsted", "28"},
                {"Koege", "Roskilde", "25"},
                {"Koege", "Vordingborg", "60"},
                {"Maribo", "Nakskov", "27"},
                {"Maribo", "Nykoebing F", "26"},
                {"Naestved", "Roskilde", "57"},
                {"Naestved", "Ringsted", "26"},
                {"Naestved", "Slagelse", "37"},
                {"Naestved", "Soroe", "32"},
                {"Naestved", "Vordingborg", "28"},
                {"Ringsted", "Roskilde", "31"},
                {"Ringsted", "Soroe", "15"},
                {"Ringsted", "Vordingborg", "58"},
                {"Slagelse", "Soroe", "14"}
        };

        Graph g = new Graph(data);
        System.out.print(Graph.minimumSpanningTreeTotalWeight(g) * COST_PER_KM + " DKK");

    }
}
