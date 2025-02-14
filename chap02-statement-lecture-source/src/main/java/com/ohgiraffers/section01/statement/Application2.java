package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {

    public static void main(String[] args) {

        /* 순서 1. Connection 생성 */
        Connection con = getConnection();

        /* 순서 2. Statement 생성 */
        Statement stmt = null;

        /* 순서 3. ResultSet 생성 */
        ResultSet rset = null;

        try {
            /* 순서 4. Connection의 createStatement()를 이용한 Statement 인스턴스 생성 */
            stmt = con.createStatement();

            String empId = "202";
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";

            System.out.println(query);

            /* 순서 5. executeQuery()로 쿼리문 실행하고 결과를 ResultSet으로 반환 받음  */
            rset = stmt.executeQuery(query);

            /* 순서 6. ResultSet에 담긴 결과물을 컬럼 이름을 이용해 꺼내어 출력 */
            if(rset.next()) {
                System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /* 순서 7. 사용한 자원 반납 */
            close(rset);
            close(stmt);
            close(con);
        }

    }

}
