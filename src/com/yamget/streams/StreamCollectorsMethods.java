package com.yamget.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import com.yamget.streams.EnumList.SexEnum;

public class StreamCollectorsMethods {
	
	/*
	 * Collectors 
	 * 1. Accumulate names into list
	 * 		List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());
	 * 
	 * 2. Accumulate names into a TreeSet
	 * 		Set<String> set = people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));
	 * 
	 * 3. Convert elements to strings and concatenate them, separated by commas
	 * 		String joined = things.stream().map(Object::toString).collect(Collectors.joining( ", "));		
	 * 
	 * 4. Compute sum of values
	 * 		double total = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
	 * 
	 * 5. Group Employees by department
	 * 		Map<Department, List<Employee>> byDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
	 * 
	 * 6. Compute sum of salaries by department
	 * 		Map<Department, Integer> totalByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));
	 * 
	 * 7. Partition students into passing and failing
	 * 		Map<Boolean, List<Student>> passingFailing = employees.stream().collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS));
	 * 
	 * Methods
	 * 		averagingDouble, averagingInt, averagingLong, 
	 * 		counting, 
	 * 		joining (3 implementation), 
	 * 		collectingAndThen, 
	 * 		groupingBy (3 implementation), groupingByConcurrent (3 implementation), 
	 * 		mapping, maxBy, minBy, partitioningBy, reducing (3 implementation), 
	 * 		summarizingDouble, summarizingInt, summarizingLong, 
	 * 		summingDouble, summingInt, summingLong,
	 * 		toCollection, toList(), toMap (3 implementation), toSet,  toConcurrentMap (3 implementation)
	 */

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("5thEmployee", SexEnum.MALE, "ACCT", 42000.00));
		employees.add(new Employee("1stEmployee", SexEnum.MALE, "IT", 5000.00));		
		employees.add(new Employee("3rdEmployee", SexEnum.MALE, "ACCT", 4100.00));
		employees.add(new Employee("4thEmployee", SexEnum.FEMALE, "SALES", 8500.00));
		employees.add(new Employee("2ndEmployee", SexEnum.FEMALE, "IT", 4000.00));
		
		
		//List to Map
		Map<String, Double> listToMap = employees.stream().collect(Collectors.toMap(Employee::getFullName, Employee::getSalary));
		System.out.println(listToMap);
		
		//SORT a map ---> Sort By Key
		Map<String, Double> sortedMapByKey = listToMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(
						Map.Entry::getKey, 
						Map.Entry::getValue,
						(oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
		System.out.println("Sorted Map by Key >>> " + sortedMapByKey);
		
		//SORT a map ---> Sort By Key
		Map<String, Double> sortedMapByValue = listToMap.entrySet().stream()
						.sorted(Map.Entry.comparingByValue())
						.collect(Collectors.toMap(
								Map.Entry::getKey, 
								Map.Entry::getValue,
								(oldValue, newValue) -> oldValue,
								LinkedHashMap::new));
		System.out.println("Sorted Map by Value >>> " + sortedMapByValue);
		
		//List to Set
		Set<Double> listToSet = employees.stream().map(Employee::getSalary).collect(Collectors.toSet());
		System.out.println(listToSet);
		
		//Collect into a list
		List<String> emps = employees.stream().map(Employee::getFullName).collect(Collectors.toList());
		System.out.println(emps);
		
		//Collect into treeSet
		Set<String> emps2 = employees.stream().map(Employee::getFullName).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(emps2);
		
		//join
		String joinedNames = employees.stream().map(Employee::getFullName).collect(Collectors.joining(", "));
		System.out.println(joinedNames);
		
		//counting
		long maleCount = employees.stream().filter(e -> e.getSex().equals(SexEnum.MALE)).count();
		System.out.println(maleCount);
		
		//partitioning
		Map<Boolean, List<Employee>> emp = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 4000));
		System.out.println("Partioning >>> " + emp);
		
		//update a single value in an object
		System.out.println("===================");
		employees.stream().map(e -> {
			if(e.getFullName().startsWith("1")) {
				e.setSex(SexEnum.FEMALE);
			}
			return e;
		}).forEach(e -> System.out.println(e.getFullName() + " " + e.getSex()));
		System.out.println("===================");
		
		//Sum of salary
		double salarySum = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(salarySum);
		
		double averageSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("Average Salary >>> " + averageSalary);
				
		//Group employee by department
		Map<String, List<Employee>> byDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(byDept);
		
		//Sum salary by department
		Map<String, Double> salaryByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
		System.out.println(salaryByDept);
		
		Map<String, Double> averageSalaryByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Average Salary By Dept >>> " + averageSalaryByDept);
		
		//reducing --- NOT Working
		Comparator<Employee> bySalary = Comparator.comparing(Employee::getSalary);
		Optional<Employee> reducedEmp = employees.stream().collect(Collectors.reducing(BinaryOperator.maxBy(bySalary)));
		System.out.println("Reducing >>> " + reducedEmp.get().getFullName());
	}

}


class Employee {
	
	private String fullName;
	
	//@Enumerated(EnumType.STRING)
	private SexEnum sex;
	
	private String department;
	private double salary;
	
	public Employee() {}
	
	public Employee(String fullName, SexEnum sex, String department, double salary) {
		super();
		this.fullName = fullName;
		this.sex = sex;
		this.department = department;
		this.salary = salary;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public SexEnum getSex() {
		return sex;
	}
	public void setSex(SexEnum sex) {
		this.sex = sex;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}

class EnumList {
	enum SexEnum {
		MALE, FEMALE
	}	
}
