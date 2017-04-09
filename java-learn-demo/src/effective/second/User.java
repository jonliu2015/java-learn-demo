package effective.second;

/**
 * Created by Liu.Zheng on 2017/3/5.
 * Builder Pattern
 */
public class User {
    private final String name;//required
    private final Integer id;//required
    private final Integer age;//optional
    private final String gender;//optional

    private User(Builder builder) {
        this.name = builder.name;
        this.id = builder.id;
        this.age = builder.age;
        this.gender = builder.gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static class Builder {
        private final String name;
        private final Integer id;
        private Integer age = 0;
        private String gender = "Unknown";

        public Builder(String name, Integer id) {
            this.name = name;
            this.id = id;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


}
