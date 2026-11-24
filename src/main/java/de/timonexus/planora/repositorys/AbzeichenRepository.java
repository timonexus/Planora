package de.timonexus.planora.repositorys;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import de.timonexus.planora.database.QueryResult;
import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.Abzeichen;

public class AbzeichenRepository implements Repository{

    @Override
    public Model[] loadAll(int nId) {
        List<Model> models = new ArrayList<>();

        try (QueryResult query = this.querySQL("sql/Abzeichen/LoadAll.sql")){
            ResultSet resultSet = query.getResultSet();
            while(resultSet.next()){
                models.add(new Abzeichen(resultSet.getInt("id"), resultSet.getString("abzeichenName"), 0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return models.toArray(new Model[0]);
    }

    @Override
    public int safe(Model nValues) {
        int id = nValues.getID();
        Abzeichen values = (Abzeichen) nValues;

            try {
                if(id > 0){
                    this.executeSQL(this.readSqlFile("sql/Abzeichen/Update.sql"), values.getAbzeichenName(), id);
                }else{
                    this.executeSQL(this.readSqlFile("sql/Abzeichen/Insert.sql"), values.getAbzeichenName());
                }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void delete(List<Integer> nLineIds) {
        for(int id: nLineIds){
            try {
                this.executeSQL(this.readSqlFile("sql/Aubzeichen/Delete.sql"), id);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public Model[] search(String nText) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
    
}
