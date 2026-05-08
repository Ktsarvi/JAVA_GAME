package items;

public class Cake extends Food {
  
  public Cake(){
    super("Cake", 25, false);
  }

  @Override
  public void use(){
    // Sound/Animation of eating
  }
}
