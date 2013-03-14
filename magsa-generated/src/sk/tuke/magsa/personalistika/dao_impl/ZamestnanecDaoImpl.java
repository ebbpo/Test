package sk.tuke.magsa.personalistika.dao_impl;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sk.tuke.magsa.framework.CRUDDaoImpl;
import sk.tuke.magsa.framework.ValidatorException;
import sk.tuke.magsa.framework.ConnectionPool;
import sk.tuke.magsa.personalistika.entity.Zamestnanec;
import sk.tuke.magsa.personalistika.dao.ZamestnanecDao;

public class ZamestnanecDaoImpl extends CRUDDaoImpl<Zamestnanec> implements ZamestnanecDao {
    public ZamestnanecDaoImpl(ConnectionPool pool) {
        super(pool);
    }

    protected PreparedStatement prepareInsertStatement(Connection connection, Zamestnanec object) throws SQLException {
        String query = "INSERT INTO Zamestnanec (meno, priezvisko, vek, zrucnosti) VALUES (?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, object.getMeno());
        pstm.setString(2, object.getPriezvisko());
        pstm.setInt(3, object.getVek());
        pstm.setArray(4, object.getZrucnosti());
        return pstm;
    }

    protected PreparedStatement prepareUpdateStatement(Connection connection, Zamestnanec object) throws SQLException {
        String query = "UPDATE Zamestnanec SET meno=?,  priezvisko=?,  vek=?,  zrucnosti=?  WHERE ident=?";
        PreparedStatement pstm = connection.prepareStatement(query);
        pstm.setString(1, object.getMeno());
        pstm.setString(2, object.getPriezvisko());
        pstm.setInt(3, object.getVek());
        pstm.setArray(4, object.getZrucnosti());
        return pstm;
    }

    protected PreparedStatement prepareDeleteStatement(Connection connection, Zamestnanec object) throws SQLException {
       String query= "DELETE FROM Zamestnanec WHERE ident=?";
       PreparedStatement pstm = connection.prepareStatement(query);
       pstm.setInt(1, object.getIdent());
       return pstm;
    }

    protected PreparedStatement prepareFindStatement(Connection connection, Integer id) throws SQLException {
        String query= "SELECT ident, meno, priezvisko, vek, zrucnosti FROM Zamestnanec WHERE ident=?";
        PreparedStatement pstm = connection.prepareStatement(query);
        pstm.setInt(1, id);
        return pstm;
    }

    protected PreparedStatement prepareSelectStatement(Connection connection) throws SQLException {
        String query= "SELECT ident, meno, priezvisko, vek, zrucnosti FROM Zamestnanec";
        PreparedStatement pstm = connection.prepareStatement(query);
        return pstm;
    }

    protected Zamestnanec createFromResultSet(ResultSet rs) throws SQLException {
        Zamestnanec result = new Zamestnanec();
        result.setIdent(rs.getInt("ident"));
        result.setMeno(rs.getString("meno"));
        result.setPriezvisko(rs.getString("priezvisko"));
        result.setVek(rs.getInt("vek"));
        result.setZrucnosti(rs.getArray("zrucnosti"));
    return result;
    }

    @Override
    protected void test(Zamestnanec object) {

        
    
    if (object.getPriezvisko() == null){
             throw new ValidatorException("Property 'priezvisko' is required!");
}   
      if (object.getPriezvisko() != null){
        if(object.getPriezvisko().length() > 16 || object.getPriezvisko().length() < -2147483648){
            throw new ValidatorException("Property 'priezvisko' has length out of range!");
}   
    }    if (object.getPriezvisko() != null){
        Pattern constraintPattern = Pattern.compile("[A-Z]([a-z]*)");
        Matcher constraintMatcher = constraintPattern.matcher(object.getPriezvisko());
        if (!constraintMatcher.find()){
        throw new ValidatorException("Property 'priezvisko' does not match the pattern!");
           }
}    
    if (object.getVek() != null){
        if(object.getVek() > 40 || object.getVek() < 18){
            throw new ValidatorException("Property 'vek' has length out of range!");
}   
    }    
 

    
    }
}
