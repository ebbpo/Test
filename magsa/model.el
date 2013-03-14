# Department
entity Department {
    name : string required, length 2 30
    code : string required, length 1 4
    level : real
    nick : string length 2 10
}

# Employee
entity Employee {
    name : string required, length 2 30
    surname : string required, length 2 30
    age : integer
}

entity Car {
    spz : string required
    owner : string
}

reference Employee Department
