package de.timonexus.planora.repositorys.utilRepositorys;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import de.timonexus.planora.database.QueryResult;
import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.utilModels.DienstAusbilder_UM;
import de.timonexus.planora.repositorys.Repository;

public class DienstAusbilder_UR implements Repository{

	@Override
	public Model[] loadAll(int nId) {
        List<Model> models = new ArrayList<>();
        try(QueryResult query = this.querySQL(this.readSqlFile("sql/utilTables/DienstAusbilder_UT/LoadAll.sql"), nId)){
            ResultSet resultSet = query.getResultSet();
            while (resultSet.next()){
                models.add(new DienstAusbilder_UM(resultSet.getInt("id"), resultSet.getInt("idDienst"), resultSet.getInt("idAusbilder"), resultSet.getString("ausbilderName"), resultSet.getBoolean("anwesenheitKleine"), resultSet.getBoolean("anwesenheitGroße")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return models.toArray(new Model[0]);
	}

	public Model[] loadAllId(int nId) {
        List<Model> models = new ArrayList<>();
        try(QueryResult query = this.querySQL(this.readSqlFile("sql/utilTables/DienstAusbilder_UT/LoadAll_id.sql"), nId)){
            ResultSet resultSet = query.getResultSet();
            while (resultSet.next()){
                models.add(new DienstAusbilder_UM(resultSet.getInt("id"), resultSet.getInt("idDienst"), resultSet.getInt("idAusbilder"), resultSet.getString("ausbilderName"), resultSet.getBoolean("anwesenheitKleine"), resultSet.getBoolean("anwesenheitGroße")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return models.toArray(new Model[0]);
	}

	@Override
	public int safe(Model nValues) {
        int id = nValues.getID();
        DienstAusbilder_UM values = (DienstAusbilder_UM) nValues;

        try {
            if(id > 0){
                this.executeSQL(this.readSqlFile("sql/utilTables/DienstAusbilder_UT/Update.sql"), values.isParticipationYounger(), values.isParticipationOlder(), values.isParticipationWhole(), id);
            }else{
                this.executeSQL(this.readSqlFile("sql/utilTables/DienstAusbilder_UT/Insert.sql"), values.getIdAusbilder(), values.getIdDienst(), values.isParticipationYounger(), values.isParticipationOlder(), values.isParticipationWhole());     
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
				this.executeSQL(this.readSqlFile("sql/utilTables/DienstAusbilder_UT/Delete.sql"), id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}

	@Override
	public Model[] search(String nText) {
        return new Model[0];
	}
    
}
