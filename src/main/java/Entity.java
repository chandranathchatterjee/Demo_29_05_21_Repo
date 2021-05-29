public class Entity {

    public String id;
    public String name;
    public String type;
    public String owner;

    public String getId() {
        return id;
    }

    public Entity(String id, String name, String type, String owner) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.owner = owner;
    }

    public Entity(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
