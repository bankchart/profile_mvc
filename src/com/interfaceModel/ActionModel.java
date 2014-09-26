package com.interfaceModel;
import java.sql.ResultSet;
import com.model.Member;

public interface ActionModel {
	public Member query(String tableName, String pointerName, String pointerValue);
	public ResultSet update(String tableName, String field, String update, String pointerName, String pointerValue);
	public boolean insert(String tableName, String[] fields, String[] values);
}
