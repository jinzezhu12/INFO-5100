package Question_4;

public class Student {
    private String name;
    private String id;

    public Student(String name, String id){
        this.name = name;
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }
}
