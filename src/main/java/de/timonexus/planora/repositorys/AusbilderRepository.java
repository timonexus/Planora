package de.timonexus.planora.repositorys;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import de.timonexus.planora.database.QueryResult;
import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.Ausbilder;

public class AusbilderRepository implements Repository{

	@Override
	public Model[] loadAll() {
        List<Model> models = new ArrayList<>();

        try (QueryResult query = this.querySQL(this.readSqlFile("sql/Ausbilder/LoadAll.sql"))){
            ResultSet resultSet = query.getResultSet();
            while (resultSet.next()) {
                models.add(new Ausbilder(resultSet.getInt("id"), resultSet.getString("name"), List.of()));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return models.toArray(new Model[0]);
	}

	@Override
	public int safe(Model nValues) {
        int id = nValues.getID();
        Ausbilder values = (Ausbilder) nValues;

        try {
            if(id > 0){
                this.executeSQL(this.readSqlFile("sql/Ausbilder/Update.sql"), values.getName(), id);
            }else{
				this.executeSQL(this.readSqlFile("sql/Ausbilder/Insert.sql"), values.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
	}

	@Override
	public void delete(List<Integer> nLineIds) {
        for(int id : nLineIds){
            try {
				this.executeSQL(this.readSqlFile("sql/Ausbilder/Delete.sql"), id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}

	@Override
	public Model[] search(String nText) {
        List<Model> models = new ArrayList<>();
        
        try (QueryResult query = this.querySQL(this.readSqlFile("sql/Ausbilder/Search.sql"), nText, nText)){
            ResultSet resultSet = query.getResultSet();
            while(resultSet.next()){
                models.add(new Ausbilder(resultSet.getInt("id"), resultSet.getString("name"), List.of()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return models.toArray(new Model[0]);
	}
    
}
