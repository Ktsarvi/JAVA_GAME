package items;

public class Potion extends Food {
  
  public Potion(){
    super("Potion", 50, true);
  }

  @Override
  public void use(){
    // Sound/Animation of eating
  }
}
