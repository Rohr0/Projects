import React, { useState, useEffect } from 'react';
import stockData from '../components/stocks.json';
import '../styles/SearchStyle.css'

function Search2() {
  const [data, setData] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const [filteredData, setFilteredData] = useState([]);
  const [isSearching, setIsSearching] = useState(false);
  const [currentPage, setCurrentPage] = useState(1);
  const resultsPerPage = 600;

  useEffect(() => {
    setData(stockData);
  }, []);

  useEffect(() => {
    setFilteredData(data);

    const filterData = () => {
      if (data) {
        const filtered = data.filter(
          (item) =>
            item['Company Name'].toLowerCase().includes(searchTerm.toLowerCase()) ||
            item['Symbol'].toLowerCase().includes(searchTerm.toLowerCase() ||
              item['Industry'].toLowerCase().includes(searchTerm.toLowerCase()))
        );
        setFilteredData(filtered);
      }
    };

    if (isSearching) {
      filterData();
    }
  }, [searchTerm, isSearching, data]);

  const indexOfLastResult = currentPage * resultsPerPage;
  const indexOfFirstResult = indexOfLastResult - resultsPerPage;
  const currentResults = filteredData.slice(indexOfFirstResult, indexOfLastResult);

  // Calculate the total number of pages
  const totalPages = Math.ceil(filteredData.length / resultsPerPage);

  const paginate = (pageNumber) => {
    setCurrentPage(pageNumber);
  };

  return (
    <div>
      <h1>Stocks Trading in NIFTY 500</h1>
      <input
        type="text"
        placeholder="Search by name or symbol"
        value={searchTerm}
        onChange={(e) => {
          setSearchTerm(e.target.value);
          setIsSearching(e.target.value.length > 0);
          setCurrentPage(1);
        }}
      />
      {data.length > 0 && currentResults.length > 0 ? (
        <div>
          <table>
            <thead>
              <tr>
                <th>Company Name</th>
                <th>Industry</th>
                <th>Symbol</th>
                <th>ISIN Code</th>
              </tr>
            </thead>
            <tbody>
              {currentResults.map((item, index) => (
                <tr key={index}>
                  <td>{item['Company Name']}</td>
                  <td>{item['Industry']}</td>
                  <td>{item['Symbol']}</td>
                  <td>{item['ISIN Code']}</td>
                </tr>
              ))}
            </tbody>
          </table>
          <div className="pagination">
            <button
              onClick={() => paginate(currentPage - 1)}
              disabled={currentPage === 1}
            >
              Previous
            </button>
            <button
              onClick={() => paginate(currentPage + 1)}
              disabled={currentResults.length < resultsPerPage || currentPage === totalPages}
            >
              Next
            </button>
            <p>Page {currentPage} of {totalPages}</p>
          </div>
        </div>
      ) : (
        <p>No data available.</p>
      )}
    </div>
  );
}

export default Search2;