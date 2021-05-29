import java.util.*;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String[] args) {
        Entity entity1 = new Entity("GIDS_0098","App1","Application","sakub.azam@globalids.com");
        Entity entity2 = new Entity("GIDS_0099","App2","Application","sakub.azam@globalids.com");
        Entity entity3 = new Entity("GIDS_0100","BE1","Business Entity","sakub.azam@globalids.com");
        Map<String,List<Entity>> entityBeans = new HashMap<String, List<Entity>>();
        List<Entity> entityList1=new ArrayList<Entity>();
        entityList1.add(entity1);
        entityList1.add(entity2);
        entityList1.add(entity3);
        List<Entity> entityList2=new ArrayList<Entity>();
        entityList2.add(entity1);
        entityList2.add(entity3);
        entityBeans.put("CAT_002",entityList2);
        entityBeans.put("CAT_001",entityList1);
        List<String> names = Arrays.asList("BE","App","DB","Schema","table","Column");
        List<String> filteredList=names.stream().filter(s -> s.startsWith("B") || s.endsWith("B")).collect(Collectors.toList());
        System.out.println(filteredList);

        //Practice.readMap(entityBeans);

    }
    private static void readMap(Map<String,List<Entity>> dataMap){
        for (Map.Entry<String,List<Entity>> entry : dataMap.entrySet()){
            int i=1;
            String keyID = entry.getKey();
            List<Entity> value= entry.getValue();
            for (Entity eachValue: value){
                System.out.println("ID of Entity # "+i+" for the key "+keyID+" is: "+ eachValue.getId());
                System.out.println("Name of Entity # "+i+" for the key "+keyID+ "is: "+eachValue.getName());
                System.out.println("Owner of the entity # "+i+" for the key "+keyID+" is: "+ eachValue.getOwner());
                System.out.println("Type of the entity # "+i+" for the key "+keyID+" is: "+eachValue.getType());
                i++;
            }

        }
    }
}
