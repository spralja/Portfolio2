public class Main {
    private static final int COST_PER_KM = 100000;
    public static void main(String[] args) {
        String[][] data = {
                {"Eskildstrup", "Maribo", "28"},
                {"Eskildstrup", "Nykøbing F", "13"},
                {"Eskildstrup", "Vordingborg", "24"},
                {"Haslev", "Korsør", "60"},
                {"Haslev", "Køge", "24"},
                {"Haslev", "Næstved", "25"},
                {"Haslev", "Ringsted", "19"},
                {"Haslev", "Roskilde", "47"},
                {"Haslev", "Slagelse", "48"},
                {"Haslev", "Sorø", "34"},
                {"Haslev", "Vordingborg", "40"},
                {"Holbæk", "Jærgerspris", "34"},
                {"Holbæk", "Kalundborg", "44"},
                {"Holbæk", "Korsør", "66"},
                {"Holbæk", "Ringsted", "36"},
                {"Holbæk", "Roskilde", "32"},
                {"Holbæk", "Slagelse", "46"},
                {"Holbæk", "Sorø", "34"},
                {"Jærgerspris", "Korsør", "95"},
                {"Jærgerspris", "Køge", "58"},
                {"Jærgerspris", "Ringsted", "56"},
                {"Jærgerspris", "Roskilde", "33"},
                {"Jærgerspris", "Slagelse", "74"},
                {"Jærgerspris", "Sorø", "63"},
                {"Kalundborg", "Ringsted", "62"},
                {"Kalundborg", "Roskilde", "70"},
                {"Kalundborg", "Slagelse", "39"},
                {"Kalundborg", "Sorø", "51"},
                {"Korsør", "Næstved", "45"},
                {"Korsør", "Slagelse", "20"},
                {"Køge", "Næstved", "45"},
                {"Køge", "Ringsted", "28"},
                {"Køge", "Roskilde", "25"},
                {"Køge", "Vordingborg", "60"},
                {"Maribo", "Nakskov", "27"},
                {"Maribo", "Nykøbing F", "26"},
                {"Næstved", "Roskilde", "57"},
                {"Næstved", "Ringsted", "26"},
                {"Næstved", "Slagelse", "37"},
                {"Næstved", "Sorø", "32"},
                {"Næstved", "Vordingborg", "28"},
                {"Ringsted", "Roskilde", "31"},
                {"Ringsted", "Sorø", "15"},
                {"Ringsted", "Vordingborg", "58"},
                {"Slagelse", "Sorø", "14"}
        };

        Graph g = new Graph(data);
        Graph.printMSTPrims(g);

    }
}
