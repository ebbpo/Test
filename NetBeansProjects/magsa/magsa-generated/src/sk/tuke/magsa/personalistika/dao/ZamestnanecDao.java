package sk.tuke.magsa.personalistika.dao;

import sk.tuke.magsa.framework.CRUDDao;
import sk.tuke.magsa.personalistika.entity.Zamestnanec;
import java.util.List;
public interface ZamestnanecDao extends CRUDDao<Zamestnanec> {
void create(Zamestnanec entity);
void edit(Zamestnanec entity);
void remove(Zamestnanec entity);
Zamestnanec find(Integer id);
public List<Zamestnanec> selectAll();
}
