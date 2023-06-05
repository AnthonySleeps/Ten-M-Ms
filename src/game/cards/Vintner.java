package src.game.cards;

//  imports
import src.game.cards.godtype.Minerva;
import src.game.player.Player;
import src.game.Good;
import src.game.House;

//import java.awt.Graphics;

//Depending on future implementation, may incorporate all Specialist cards under
//one superclass/interface
public class Vintner extends PersonalityCard implements Minerva {
   public final CardImage IMAGE = CardImage.VINTNER;
   public final Good GOOD = Good.WINE;

   public Vintner(Player myPlayer) {
      super(myPlayer, 1, 0, 0, 1, 0, 4);
   }
   
   @Override
   public void doAction() {
      //All owned cities of specified type produce
      Player p = getMyPlayer();
      for(House h : p.houses()) {
         if(h.good() == GOOD) {
            p.storeHouse().add(GOOD);
         }
      }
      setPlayed(true);
   }
   
   @Override
   public int calculatePoints() {
      return getVictoryMultiplier() * minervaScorePoints();
   }
   
   @Override
   public void update() {
      
   }
   
   @Override
   public Player getPlayer() {
      return super.getMyPlayer();
   }
   
   @Override
   public Good specialistType() {
      return Good.WINE;
   }
}