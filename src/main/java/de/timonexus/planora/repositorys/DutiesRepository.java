package de.timonexus.planora.repositorys;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.timonexus.planora.database.QueryResult;
import de.timonexus.planora.models.Model;
import de.timonexus.planora.models.Models.Dutie;

public class DutiesRepository implements Repository{

    @Override
    public Model[] loadAll() {

        List<Model> models = new ArrayList<>();

        try (QueryResult query = this.querySQL(
                this.readSqlFile("sql/Duties/LoadAll.sql"))) {

            ResultSet resultSet = query.getResultSet();

            while (resultSet.next()) {

                models.add(new Dutie(
                    resultSet.getInt("id"),
                    resultSet.getString("date"),
                    resultSet.getString("time_kleine"),
                    resultSet.getString("time_große"),
                    ""
                ));
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return models.toArray(new Model[0]);
    }

    @Override
    public void safe(Model nValues) {
        int id = nValues.getID();
        Dutie values = (Dutie) nValues;
        if(id > 0){
            try {
				this.executeSQL(this.readSqlFile("sql/Duties/Update.sql"), values.getDate(), values.getUhrzeit_kleine(), values.getUhrzeit_große(), id);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
        }else{
            try {
				this.executeSQL(this.readSqlFile("sql/Duties/Insert.sql"), values.getDate(), values.getUhrzeit_kleine(), values.getUhrzeit_große());
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
        }
    }

    @Override
    public void delete(List<Integer> nLineIds) {
        for(int id : nLineIds){
            try {
				this.executeSQL(this.readSqlFile("sql/Duties/Delete.sql"), id);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
        }
    }

    @Override
    public Model[] search(String nText) {

        List<Model> models = new ArrayList<>();

        try (QueryResult query = this.querySQL(this.readSqlFile("sql/Duties/Search.sql"), nText, nText, nText, nText)) {

            ResultSet resultSet = query.getResultSet();

            while (resultSet.next()) {

                models.add(new Dutie(
                    resultSet.getInt("id"),
                    resultSet.getString("date"),
                    resultSet.getString("time_kleine"),
                    resultSet.getString("time_große"),
                    ""
                ));
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return models.toArray(new Model[0]);
    }
    
}
