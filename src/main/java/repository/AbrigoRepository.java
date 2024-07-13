package repository;

import model.Abrigo;

import java.util.ArrayList;
import java.util.List;

public class AbrigoRepository {

        private List<Abrigo> abrigos = new ArrayList<>();

        public void save(Abrigo abrigo) {
            abrigos.add(abrigo);
        }

        public List<Abrigo> findAll() {
            return abrigos;
        }

        public void delete(int id) {
            abrigos.removeIf(a -> a.getId() == id);
        }
}
