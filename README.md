Write one simple program (in file hashFunctions.java) that uses a fixed set of 50 unique keys stored in
an array as follows (Important: hard-code the array content in your test program and make sure you
have same exact key values below in the exact given order):
int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523



HF1(...) that implements the Division method(Linear Probing for collision resolution)

HF2(...) that implements Division method (Quadratic Probing) 

 HF3(...) that implements the Division method(Double Hashing for collision resolution).function, use the following 
H2 (key) = 30 – key % 25;
Increment is { key + j * H2 (key) } % 50 for j=1, 2, 3, 4,

HF4() that implements a hash function of your own design and F4() generates less than 80 probes for the given set of keys; and hashes 90% or more
of the keys.
