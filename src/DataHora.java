public class DataHora {
    private String datetime;

    // Getter e Setter
    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "DataHora{" +
                "data='" + datetime + '\'' +
                '}';
    }
}