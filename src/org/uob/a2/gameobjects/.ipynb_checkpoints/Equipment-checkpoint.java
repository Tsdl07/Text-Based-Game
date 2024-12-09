package org.uob.a2.gameobjects;

public class Equipment extends GameObject implements Usable {
    protected UseInformation useInformation;

    public Equipment(String id, String name, String description, boolean hidden, UseInformation useInformation){
        super(id, name, description, hidden);
        this.useInformation = useInformation;
    }

    public void setUseInformation(UseInformation useInformation){
        this.useInformation = useInformation;
    }

    public UseInformation getUseInformation(){
        return this.useInformation;
    }

    public String use(GameObject target, GameState gameState){
        Map map = gameState.getMap();
        String equipmentTarget = useInformation.getTarget();

        if(equipmentTarget.equals(target.getId())){
            Item searchedItem = map.getCurrentRoom().getItem(useInformation.getResult());
            searchedItem.setHidden(false);
            useInformation.setUsed(true);
            return useInformation.getMessage();
        }
        else{
            return "The equipment cannot be used!";
        }
        
        
    }

    
    /**
     * Returns a string representation of this equipment, including the attributes inherited from {@code GameObject}
     * and the associated use information.
     *
     * @return a string describing the equipment
     */
    @Override
    public String toString() {
        return super.toString() + ", useInformation=" + useInformation;
    }
}
