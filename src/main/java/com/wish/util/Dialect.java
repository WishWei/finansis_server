package com.wish.util;


import com.wish.model.dto.PageInfo;

public interface Dialect {
	
	@SuppressWarnings("unused")
	public static enum Type {
		MYSQL {
			public String getValue() {
				return "mysql";
			}
		},
		ORACLE {
			public String getValue() {
				return "oracle";
			}
		}
	}

	public abstract String getPageSql(String sql, PageInfo page);
}
