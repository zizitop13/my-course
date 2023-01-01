### Plan

 - [ ] Repeat 
   - [ ] Java
       - [ ] Interface, client
       - [ ] Unit tests
       - [ ] Cast
       - [ ] Generics


 - [ ] New 
   - [ ] Java
     - [ ] Hash map
     
### Homework

### Notes

KeyValue: key - value
Table:
|key  | Maksim (hash: 9)| Mikhail (hash: 12)| Irina (hash: 33)|
|value|  5A             |   13              |  5A             |

[3], 9 ->  9 % 3 = 0
[3], 13 -> 13 % 3 = 1
[3], 32 -> 33 % 3 = 0

Maksim != Irina - collision  = linked list

[0,       1,      2]
Entry(Maksim)  Entry(Mikhail)  Entry(Vanya)
 | .next
Entry(Irina)
| .next
Entry(Irina1)
| .next
Entry(Irina2)
| .next
Entry(Irina3)


Tree:
         Maksim (5A)
       /             \
     Mikhail (13)    Irina (5A)
