package test.polygon.POJO;

public class MyItem {
    private String name;
    private String gov;

    public MyItem() {
    }

    public MyItem(String name, String gov) {
        this.name = name;
        this.gov = gov;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGov() {
        return gov;
    }

    public void setGov(String gov) {
        this.gov = gov;
    }

    @Override
    public String toString() {
        return "MyItem{" +
                "name='" + name + '\'' +
                ", gov='" + gov + '\'' +
                '}';
    }
}
