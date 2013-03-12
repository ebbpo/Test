package sk.tuke.magsa.personalistika.dao;

import sk.tuke.magsa.framework.CRUDDao;
import sk.tuke.magsa.personalistika.entity.Oddelenie;
import java.util.List;
public interface OddelenieDao extends CRUDDao<Oddelenie> {
void create(Oddelenie entity);
void edit(Oddelenie entity);
void remove(Oddelenie entity);
Oddelenie find(Integer id);
public List<Oddelenie> selectAll();
}
