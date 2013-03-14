
import java.util.ArrayList;
import java.util.List;
import sk.tuke.magsa.framework.ConnectionPool;
import sk.tuke.magsa.personalistika.dao_impl.OddelenieDaoImpl;
import sk.tuke.magsa.personalistika.dao_impl.ZamestnanecDaoImpl;
import sk.tuke.magsa.personalistika.entity.Oddelenie;
import sk.tuke.magsa.personalistika.entity.Zamestnanec;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam
 */
public class Main {

    public static void main(String... args){
        ConnectionPool pool= new ConnectionPool();
//        ZamestnanecDaoImpl zamestnanecDAO = new ZamestnanecDaoImpl(pool);
//        Zamestnanec zamestnanec = zamestnanecDAO.find(4);
//        System.out.println(zamestnanec.getMeno());
//        List<Zamestnanec> zamList= zamestnanecDAO.selectAll();
//        for (Zamestnanec zamestnanec : zamList) {
//            System.out.println(zamestnanec);
//            if(zamestnanec.getIdent()!=1){
//                zamestnanecDAO.remove(zamestnanec);
//
//            }
//        }
        OddelenieDaoImpl oddelenieDAO = new OddelenieDaoImpl(pool);
        List<Oddelenie> oddelenia = oddelenieDAO.selectAll();
        for (Oddelenie oddelenie : oddelenia) {
            System.out.println(oddelenie.getKod()+" "+oddelenie.getNazov()+" "+oddelenie.getPoschodie());
        }
        }
}
