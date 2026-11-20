package de.timonexus.planora.repositorys.utilRepositorys;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import de.timonexus.planora.database.QueryResult;
import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.utilModels.DienstAusbilder_UM;
import de.timonexus.planora.repositorys.Repository;

public class DienstAusbilder_UR implements Repository{

    // attribute
    private int dienstId;

    // constructor
    public DienstAusbilder_UR(){
        this.dienstId = 0;
    }

	@Override
	public Model[] loadAll() {
        List<Model> models = new ArrayList<>();

        if(this.dienstId == 0){
            try(QueryResult query = this.querySQL(this.readSqlFile("sql/Ausbilder/LoadAll.sql"))){
                ResultSet resultSet = query.getResultSet();
                while (resultSet.next()){
                    models.add(new DienstAusbilder_UM(0, 0, resultSet.getInt("id"), resultSet.getString("name"), false, false));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            try(QueryResult query = this.querySQL(this.readSqlFile("sql/Ausbilder/LoadAll.sql"))){
                ResultSet resultSet = query.getResultSet();
                while (resultSet.next()){
                    models.add(new DienstAusbilder_UM(resultSet.getInt("id"), resultSet.getInt("idDienst"), resultSet.getInt("idAusbilder"), resultSet.getString("ausbilderName"), resultSet.getBoolean("participationYounger"), resultSet.getBoolean("participationOlder")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return models.toArray(new Model[0]);
	}

	@Override
	public void safe(Model nValues) {
        int id = nValues.getID();
        DienstAusbilder_UM values = (DienstAusbilder_UM) nValues;

        try {
            if(id > 0){
                this.executeSQL(this.readSqlFile("sql/Ausbilder/Update.sql"), values.getIdDienst(), values.getIdAusbilder(), values.isParticipationYounger(), values.isParticipationOlder(), values.isParticipationWhole(), id);
            }else{
                this.executeSQL(this.readSqlFile("sql/Ausbilder/Insert.sql"), values.getIdDienst(), values.getIdAusbilder(), values.isParticipationYounger(), values.isParticipationOlder(), values.isParticipationWhole());     
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        return new Model[0];
	}
    
}
