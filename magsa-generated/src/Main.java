
import sk.tuke.magsa.framework.ConnectionPool;
import sk.tuke.magsa.personalistika.dao_impl.ZamestnanecDaoImpl;
import sk.tuke.magsa.personalistika.entity.Zamestnanec;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adam
 */
public class Main {
    
  public static void main(String... args){
      ConnectionPool connectionPool = new ConnectionPool();
      ZamestnanecDaoImpl zamestnanecDaoImpl = new ZamestnanecDaoImpl(connectionPool);
      Zamestnanec zamestnanec = new Zamestnanec();
      zamestnanec.
  }
}
