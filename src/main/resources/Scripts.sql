-- For the Computer table
INSERT INTO `Computer` (`brand`, `model`, `is_upgradable`) VALUES
('Brand1', 'Model1', 1),
('Brand2', 'Model2', 0),
('Brand3', 'Model3', 1),
('Brand4', 'Model4', 0),
('Brand5', 'Model5', 1);

-- For the RAM table
INSERT INTO `RAM` (`capacity`, `Computer_computer_id`) VALUES
(4, 1),
(8, 2),
(16, 3),
(32, 4),
(64, 5);

-- For the Mouse table
INSERT INTO `Mouse` (`type`, `is_configurable`, `Computer_computer_id`) VALUES
('Wireless', 1, 1),
('Wired', 0, 2),
('Bluetooth', 1, 3),
('Trackball', 0, 4),
('Gaming', 1, 5);

-- For the Monitor table
INSERT INTO `Monitor` (`type`, `is_power_on`, `Computer_computer_id`) VALUES
('LED', 1, 1),
('LCD', 0, 2),
('OLED', 1, 3),
('CRT', 0, 4),
('IPS', 1, 5);

-- For the Keyboard table
INSERT INTO `Keyboard` (`type`, `Computer_computer_id`) VALUES
('Mechanical', 1),
('Membrane', 2),
('Wireless', 3),
('Ergonomic', 4),
('Gaming', 5);

-- For the Component table
INSERT INTO `Component` (`model`) VALUES
('ModelA'),
('ModelB'),
('ModelC'),
('ModelD'),
('ModelE');

-- For the GPU table
INSERT INTO `GPU` (`memory`, `boost_cloock`, `Component_id`, `Computer_computer_id`) VALUES
(4, 1500, 1, 1),
(8, 1800, 2, 2),
(6, 1600, 3, 3),
(12, 2000, 4, 4),
(16, 2200, 5, 5);

-- For the CPU table
INSERT INTO `CPU` (`manufacturer`, `speed`, `Component_id`, `Computer_computer_id`) VALUES
('Intel', 3.2, 1, 1),
('AMD', 2.8, 2, 2),
('ARM', 2.5, 3, 3),
('Apple', 3.5, 4, 4),
('Qualcomm', 2.6, 5, 5);

-- For the Desktop table
INSERT INTO `Desktop` (`form_factor`, `Computer_id`) VALUES
('Mini', 1),
('Tower', 2),
('All-in-One', 3),
('Small Form Factor', 4),
('Gaming Desktop', 5);

-- For the Laptop table
INSERT INTO `Laptop` (`battery_life_in_hours`, `Computer_id`) VALUES
(6, 1),
(8, 2),
(10, 3),
(12, 4),
(14, 5);

-- For the Tablet table
INSERT INTO `Tablet` (`has_touch_pen`, `Computer_id`) VALUES
(1, 1),
(0, 2),
(1, 3),
(0, 4),
(1, 5);

-- For the Os table
INSERT INTO `Os` (`os_name`) VALUES
('Windows'),
('macOS'),
('Linux'),
('Android'),
('iOS');



-- ####################################################################################
-- ####################################################################################

-- Update in the Computer table
UPDATE `Computer` SET `is_upgradable` = 1 WHERE `id` = 1;

-- Update in the RAM table
UPDATE `RAM` SET `capacity` = 8 WHERE `id` = 1;

-- Update in the Mouse table
UPDATE `Mouse` SET `is_configurable` = 0 WHERE `id` = 1;

-- Update in the Monitor table
UPDATE `Monitor` SET `is_power_on` = 1 WHERE `id` = 1;

-- Update in the Keyboard table
UPDATE `Keyboard` SET `type` = 'Mechanical' WHERE `id` = 1;

-- Update in the Component table
UPDATE `Component` SET `model` = 'ModelX' WHERE `id` = 1;

-- Update in the GPU table
UPDATE `GPU` SET `memory` = 6 WHERE `id` = 1;

-- Update in the CPU table
UPDATE `CPU` SET `speed` = 3.0 WHERE `id` = 1;

-- Update in the Desktop table
UPDATE `Desktop` SET `form_factor` = 'Tower' WHERE `id` = 1;

-- Update in the Laptop table
UPDATE `Laptop` SET `battery_life_in_hours` = 9 WHERE `id` = 1;

-- ####################################################################################
-- ####################################################################################

-- Disable foreign key checks
SET FOREIGN_KEY_CHECKS=0;

-- Delete from the Computer table
DELETE FROM `Computer` WHERE `id` = 3;

-- Delete from the RAM table
DELETE FROM `RAM` WHERE `id` = 3;

-- Delete from the Mouse table
DELETE FROM `Mouse` WHERE `id` = 3;

-- Delete from the Monitor table
DELETE FROM `Monitor` WHERE `id` = 3;

-- Delete from the Keyboard table
DELETE FROM `Keyboard` WHERE `id` = 3;

-- Delete from the Component table
DELETE FROM `Component` WHERE `id` = 3;

-- Delete from the GPU table
DELETE FROM `GPU` WHERE `id` = 3;

-- Delete from the CPU table
DELETE FROM `CPU` WHERE `id` = 3;

-- Delete from the Desktop table
DELETE FROM `Desktop` WHERE `id` = 3;

-- Delete from the Laptop table
DELETE FROM `Laptop` WHERE `id` = 3;

-- ####################################################################################
-- ####################################################################################

-- Add a new column to the Computer table
ALTER TABLE `Computer`
ADD COLUMN `purchase_date` DATE;

-- Add a new column 'price' to the GPU table
ALTER TABLE `GPU`
ADD COLUMN `price` DECIMAL(10, 2);

-- Add a new column to the Mouse table
ALTER TABLE `Mouse`
ADD COLUMN `color` VARCHAR(30);

-- Add a new column to the Monitor table
ALTER TABLE `Monitor`
ADD COLUMN `resolution` VARCHAR(20);

-- Add a new column to the Keyboard table
ALTER TABLE `Keyboard`
ADD COLUMN `language` VARCHAR(50);

-- Update GPU prices for IDs 1, 2, 4, and 5
UPDATE `GPU`
SET `price` = CASE
    WHEN `id` = 1 THEN 199.99
    WHEN `id` = 2 THEN 249.99
    WHEN `id` = 4 THEN 179.95
    WHEN `id` = 5 THEN 299.50
    ELSE `price`
END
WHERE `id` IN (1, 2, 4, 5);

-- Update Computer purchase_date for IDs 1, 2, 4, and 5
UPDATE `Computer`
SET `purchase_date` = CASE
    WHEN `id` = 1 THEN '2023-01-15'
    WHEN `id` = 2 THEN '2023-03-22'
    WHEN `id` = 4 THEN '2023-05-10'
    WHEN `id` = 5 THEN '2023-08-07'
    ELSE `purchase_date`
END
WHERE `id` IN (1, 2, 4, 5);

-- ####################################################################################
-- ####################################################################################

-- Query to retrieve Computer details with hardware components joined
SELECT *
FROM Computer AS C
LEFT JOIN RAM AS R ON C.id = R.Computer_computer_id
LEFT JOIN Mouse AS M ON C.id = M.Computer_computer_id
LEFT JOIN Monitor AS MO ON C.id = MO.Computer_computer_id
LEFT JOIN Keyboard AS K ON C.id = K.Computer_computer_id
LEFT JOIN GPU AS G ON C.id = G.Computer_computer_id
LEFT JOIN CPU AS CP ON C.id = CP.Computer_computer_id
LEFT JOIN Desktop AS D ON C.id = D.Computer_id
LEFT JOIN Laptop AS L ON C.id = L.Computer_id
LEFT JOIN Tablet AS T ON C.id = T.Computer_id;

-- ####################################################################################
-- ####################################################################################

-- Query 1: Left join Computer with RAM, Mouse, and Monitor (LEFT JOIN)
SELECT *
FROM Computer AS C
LEFT JOIN RAM AS C_RAM ON C.id = C_RAM.Computer_computer_id
LEFT JOIN Mouse AS C_Mouse ON C.id = C_Mouse.Computer_computer_id
LEFT JOIN Monitor AS C_Monitor ON C.id = C_Monitor.Computer_computer_id;

-- Query 2: Right join Computer with GPU (RIGHT JOIN)
SELECT *
FROM Computer AS C
RIGHT JOIN GPU AS C_GPU ON C.id = C_GPU.Computer_computer_id;

-- Query 3: Inner join Computer with CPU (INNER JOIN)
SELECT *
FROM Computer AS C
INNER JOIN CPU AS C_CPU ON C.id = C_CPU.Computer_computer_id;

-- Query 4: Full outer join between Computer and RAM (LEFT JOIN and RIGHT JOIN combined with UNION)
SELECT *
FROM Computer AS C
LEFT JOIN RAM AS C_RAM ON C.id = C_RAM.Computer_computer_id
UNION
SELECT *
FROM Computer AS C
RIGHT JOIN RAM AS C_RAM ON C.id = C_RAM.Computer_computer_id;

-- Query 5: Cross join between Computer and GPU (CROSS JOIN)
SELECT *
FROM Computer AS C
CROSS JOIN GPU AS C_GPU;

-- ####################################################################################
-- ####################################################################################

-- Statement 1: Calculating the average price of GPUs
SELECT AVG(price) AS average_price
FROM GPU;

-- Statement 2: Finding the maximum price of GPUs for each memory size
SELECT memory, MAX(price) AS max_price
FROM GPU
GROUP BY memory;

-- Statement 3: Calculating the total price of all GPUs
SELECT SUM(price) AS total_price
FROM GPU;

-- Statement 4: Counting the number of GPUs for each price range (assuming price ranges)
SELECT FLOOR(price / 100) * 100 AS price_range, COUNT(*) AS gpu_count
FROM GPU
GROUP BY FLOOR(price / 100) * 100;

-- Statement 5: Finding the cheapest GPU price per memory size
SELECT memory, MIN(price) AS min_price
FROM GPU
GROUP BY memory;

-- Statement 6: Calculating the number of GPUs above a certain price
SELECT CASE
    WHEN price > 300 THEN 'Above 300'
    ELSE '300 and below'
    END AS price_range,
    COUNT(*) AS gpu_count
FROM GPU
GROUP BY CASE
    WHEN price > 300 THEN 'Above 300'
    ELSE '300 and below'
    END;

-- Statement 7: Calculating the average price for each memory size range (assuming predefined ranges)
SELECT CASE
    WHEN memory <= 4 THEN '4GB and below'
    WHEN memory > 4 AND memory <= 8 THEN '5-8GB'
    ELSE 'Above 8GB'
    END AS memory_range,
    AVG(price) AS average_price
FROM GPU
GROUP BY CASE
    WHEN memory <= 4 THEN '4GB and below'
    WHEN memory > 4 AND memory <= 8 THEN '5-8GB'
    ELSE 'Above 8GB'
    END;

-- ####################################################################################
-- ####################################################################################

-- Statement 1: Count of Computers purchased in each year with having
SELECT YEAR(purchase_date) AS purchase_year, COUNT(*) AS computer_count
FROM Computer
GROUP BY purchase_year
HAVING COUNT(*) > 3; -- Having more than 3 purchases per year


-- Statement 2: Average number of Computers purchased per month
SELECT YEAR(purchase_date) AS purchase_year, MONTH(purchase_date) AS purchase_month, COUNT(*) AS computer_count
FROM Computer
GROUP BY purchase_year, purchase_month
HAVING COUNT(*) >= 1; -- Having more or equal than 1 purchases in a month

-- Statement 3: List of years with more than 3 Computers purchased
SELECT YEAR(purchase_date) AS purchase_year, COUNT(*) AS computer_count
FROM Computer
GROUP BY purchase_year
HAVING COUNT(*) > 3;

-- Statement 4: Number of Computers purchased by brand where the count is more or equal than 1
SELECT brand, COUNT(*) AS computer_count
FROM Computer
GROUP BY brand
HAVING COUNT(*) >= 1;

-- Statement 5: List of days where more or equal than 1 Computers were purchased
SELECT DAY(purchase_date) AS purchase_day, COUNT(*) AS computer_count
FROM Computer
GROUP BY purchase_day
HAVING COUNT(*) >= 1;

-- Statement 6: Total count of Computers purchased for each brand
SELECT brand, COUNT(*) AS computer_count
FROM Computer
GROUP BY brand
HAVING COUNT(*) < 50; -- Brands with less than 50 purchases

-- Statement 7: Average count of Computers purchased per quarter with having
SELECT YEAR(purchase_date) AS purchase_year, QUARTER(purchase_date) AS purchase_quarter, COUNT(*) AS computer_count
FROM Computer
GROUP BY purchase_year, purchase_quarter
HAVING COUNT(*) >= 1; -- Having at least 1 purchases per quarter

-- ####################################################################################
-- ####################################################################################