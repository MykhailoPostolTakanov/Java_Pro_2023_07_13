package JDBC;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class HeroDaoImpl implements HeroDao {
    private final DataSource dataSource;

    @Override
    public List<Hero> findAll() {
        var sql = "select * from hero";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHero(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Hero> findByName(String name) {
        var sql = "select * from hero where name = '" + name + "'";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHero(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Hero hero) {
        var sql = "insert into hero (name,gender,eyeColor,race,hairColor,height,publisher,skinColor,alignment,weight)" +
                "values('" + hero.getName() + "','" + hero.getGender() + "','" + hero.getEyeColor() + "','" + hero.getRace() + "','" + hero.getHairColor() + "'," +
                hero.getHeight() + ",'" + hero.getPublisher() + "','" + hero.getSkinColor() + "','" + hero.getAlignment() + "'," + hero.getWeight() + ")";
        try (var connection = dataSource.getConnection(); var statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Hero hero) {
        var sql = "update hero set  name='" + hero.getName() + "',gender='" + hero.getGender() + "',eyeColor='" + hero.getEyeColor() + "',race='" + hero.getRace() +
                "',hairColor='" + hero.getHairColor() + "',height=" + hero.getHeight() + ",publisher='" + hero.getPublisher() + "',skinColor='" + hero.getSkinColor() +
                "',alignment='" + hero.getAlignment() + "',weight=" + hero.getWeight() + " where id='" + hero.getId() + "'";
        try (var connection = dataSource.getConnection(); var statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        var sql = "delete from hero where id=" + id;
        try (var connection = dataSource.getConnection(); var statement = connection.createStatement()) {
            var res = statement.executeUpdate(sql);
            return res == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private LinkedList<Hero> mapHero(ResultSet result) throws SQLException {
        var heroes = new LinkedList<Hero>();
        while (result.next()) {
            heroes.add(new Hero(result.getLong("id"),
                    result.getString("name"),
                    result.getString("gender"),
                    result.getString("eyeColor"),
                    result.getString("race"),
                    result.getString("hairColor"),
                    result.getLong("height"),
                    result.getString("publisher"),
                    result.getString("skinColor"),
                    result.getString("alignment"),
                    result.getInt("weight")));
        }
        return heroes;
    }
}
