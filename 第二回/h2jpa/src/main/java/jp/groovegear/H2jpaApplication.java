package jp.groovegear;

import jp.groovegear.Customer;
import jp.groovegear.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class H2jpaApplication implements CommandLineRunner{
  @Autowired
  CustomerRepository customerRepository;

  @Override
  public void run(String...strings ) throws Exception {
    //データ追加
    Customer created = customerRepository.save(new Customer(null, "Hidetoshi", "Dekisugi"));
    System.out.println(created + " is created!");

    //ページング処理
    Pageable pageable = new PageRequest(0, 3);
    Page<Customer> page = customerRepository.findAllOderByName(pageable);
    System.out.println("１ページのデータ数 = " + page.getSize());
    System.out.println("現在のページ = " + page.getNumber());
    System.out.println("全ページ数 = " + page.getTotalPages());
    System.out.println("全データ数 = " + page.getTotalElements());
    page.getContent().forEach(System.out::println);
  }

  public static void main(String[] args) {
    SpringApplication.run(H2jpaApplication.class, args);
  }
}
