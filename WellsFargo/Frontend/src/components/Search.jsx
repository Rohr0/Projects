import React, { useState, useEffect } from 'react';
import stockData from './resources/data/nse-listed-stocks.json';

function Search() {
  const [data, setData] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const [filteredData, setFilteredData] = useState([]);
  const [isSearching, setIsSearching] = useState(false);

  useEffect(() => {
    // Convert the object into an array of objects
    const dataArray = Object.keys(stockData).map((key) => ({
      name: key,
      symbol: stockData[key],
    }));

    setData(dataArray);
  }, []);

  useEffect(() => {
    // Set the filtered data to an empty array
    setFilteredData([]);

    // Function to filter data based on the search term
    const filterData = () => {
      const filtered = data.filter((item) =>
        item.name.toLowerCase().includes(searchTerm.toLowerCase())
      );
      setFilteredData(filtered);
    };

    // Filter the data if the user is searching
    if (isSearching) {
      filterData();
    }
  }, [searchTerm, isSearching, data]);

  return (
    <div>
      <h1>JSON Data Filter</h1>
      <input
        type="text"
        placeholder="Search by name"
        value={searchTerm}
        onChange={(e) => {
          setSearchTerm(e.target.value);
          setIsSearching(e.target.value.length > 0);
        }}
      />
      <ul>
        {filteredData.map((item, index) => (
          <li key={index}>
            {item.name} ({item.symbol})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Search;
